@EntityListeners(AbstractDTOJpaEventListener.class)
@MappedSuperclass
public abstract class AbstractDTO implements Storeable, Serializable, Cloneable {
  /** */
  private static final String SHADOWED_CLASS = "Custom";
  /** */
  protected final static boolean DEBUG_CUSTOM_INSTANCES = true;
  /** */
  public static long TARGET_HITRATE_PER_INTERVAL = 400000;
  /** */
  public static long LOGGING_INTERVAL = Times.MILLISECONDS_IN_TEN_SECONDS;
  /** */
  private static long previousLoggingTime;
  /** */
  protected static int hits;
  /** */
  protected static boolean hitting;
  /** */
  protected static int hitsWithinInterval;

  /**
   * @author Martin
   */
  public static class Hi {
    /**
     * 
     */
    private long hitted;
    private final long createdAt;
    private final StackTraceElement[] stackTraceElements;
    private final String threadName;

    /**
     * @param threadName 
     * @param stackTraceElements 
     */
    public Hi(String threadName, StackTraceElement[] stackTraceElements) {
      this.threadName = threadName;
      this.createdAt = System.currentTimeMillis();
      this.stackTraceElements = stackTraceElements;
    }

    /**
     *
     */
    public void hit() {
      hitted++;
    }

    /**
     * @return the hitted
     */
    public long getHitted() {
      return hitted;
    }

    /**
     * @param hitted the hitted to set
     */
    public void setHitted(long hitted) {
      this.hitted = hitted;
    }

    /**
     * @return the createdAt
     */
    public long getCreatedAt() {
      return createdAt;
    }

    /**
     * @return the stackTraceElements
     */
    public StackTraceElement[] getStackTraceElements() {
      return stackTraceElements;
    }

    /**
     * @return the threadName
     */
    public String getThreadName() {
      return threadName;
    }
  }

  /** */
  protected final static Map<String, Hi> INSTANCE_SHADOW = new ConcurrentHashMap<String, Hi>();

  private static final Comparator<? super Entry<String, Hi>> COMPARATOR = new Comparator<Entry<String, Hi>>() {
    @Override
    public int compare(Entry<String, Hi> o1, Entry<String, Hi> o2) {
      if (o1 == o2) {
        return 0;
      }

      return -Utils.compareNullSafe(o1.getValue().getHitted(), o2.getValue().getHitted(), Compare.ARG0_FIRST);
    }
  };

  /**
   * @param <T> 
   * @return T
   * @see java.lang.Object#clone()
   */
  @SuppressWarnings("unchecked")
  public <T extends AbstractDTO> T clone() {
    try {
      return (T) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    } finally {
      if (DEBUG_CUSTOM_INSTANCES && getClass().getSimpleName().equals(SHADOWED_CLASS)) {
        shadowInstance();
      }
    }
  }

  /**
   * 
   */
  protected void shadowInstance() {
    if (DEBUG_CUSTOM_INSTANCES) {
      final long currentTimeMillis = System.currentTimeMillis();

      if (TARGET_HITRATE_PER_INTERVAL <= ++hitsWithinInterval) {
        hitting = true;
      }

      if ((TARGET_HITRATE_PER_INTERVAL / 2) <= ++hits) {
        final Thread currentThread = Thread.currentThread();

        final StackTraceElement[] stackTrace = currentThread.getStackTrace();

        final String key = Utils.getPropertyPath(String.valueOf(System.identityHashCode(currentThread)), displayStackLocaktion(stackTrace))
            .intern();

        Hi hi = INSTANCE_SHADOW.get(key);

        if (hi == null) {
          synchronized (key) {
            hi = INSTANCE_SHADOW.get(key);

            if (hi == null) {
              INSTANCE_SHADOW.put(key, hi = new Hi(currentThread.getName(), stackTrace));
            }

          }
        }

        hi.hit();
      }

      {
        if (getLoggingInterval(currentTimeMillis) != getLoggingInterval(previousLoggingTime)) {
          if (hitsWithinInterval < TARGET_HITRATE_PER_INTERVAL) {
            if (hitting) {
              hitting = false;
            } else {
              hits = 0; // Reset measuring on second round, give chance to burtsy hits
            }
          }

          hitsWithinInterval = 0;
          previousLoggingTime = currentTimeMillis;
        }
      }
    }
  }

  /**
   * @param time
   * @return long
   */
  private long getLoggingInterval(long time) {
    return time / LOGGING_INTERVAL;
  }

  /**
   * @return String
   */
  public static String toStringShadows() {
    final ArrayList<Entry<String, Hi>> entries;

    synchronized (INSTANCE_SHADOW) {
      entries = Convert.toMinimumArrayList(INSTANCE_SHADOW.entrySet());
      INSTANCE_SHADOW.clear();
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(new Timestamp(System.currentTimeMillis()) + " " + SHADOWED_CLASS + " Class instance instantiantion summary:\n");
    stringBuilder.append("hits=" + hits + ", hitting=" + hitting + ", hitsWithinInterval=" + hitsWithinInterval + ", previousLoggingTime=" + new java.sql.Timestamp(previousLoggingTime));

    if (entries.isEmpty()) {
      return stringBuilder.toString();
    }

    Collections.sort(entries, COMPARATOR);

    int index = 0;
    stringBuilder.append("-----------------------------------------------------------------------");

    for (Entry<String, Hi> entry : entries) {
      Utils.append(stringBuilder, entry.getValue().getHitted() + "\t" + entry.getKey(), "\n");
    }

    for (Entry<String, Hi> entry : entries) {
      final Hi hi = entry.getValue();
      final StackTraceElement[] stackTrace = hi.getStackTraceElements();
      final String groupName = entry.getKey();

      final String threadName = hi.getThreadName();

      stringBuilder.append("\n").append(++index).append('\t');
      stringBuilder.append(hi.getHitted()).append("\tpcs\t").append(groupName);
      stringBuilder.append("\t").append(new Timestamp(hi.getCreatedAt()).toString()).append('\t').append(threadName)
          .append('\t').append(Convert.toString(stackTrace));
    }

    return stringBuilder.toString();
  }

  /**
   * @param stackTrace
   * @return String
   */
  private static String displayStackLocaktion(final StackTraceElement[] stackTrace) {
    StackTraceElement firstDistinguishingStackTraceElement = null;

    for (int index = 0; index < stackTrace.length; index++) {
      firstDistinguishingStackTraceElement = stackTrace[index];
      if (!Arrays.asList(UNWANTED_LOCATIONS).contains(firstDistinguishingStackTraceElement.getClassName())) {
        break;
      }
    }

    StackTraceElement lastDistinguishingStackTraceElement = null;

    for (int index = stackTrace.length-1; 0 <= index; index--) {
      lastDistinguishingStackTraceElement = stackTrace[index];
      if (lastDistinguishingStackTraceElement.getClassName().startsWith(OUR_PACKAGE_DOMAIN)) {
        break;
      }
    }

    return Utils.getPropertyPath(displayName(firstDistinguishingStackTraceElement) + "<-"
        + displayName(lastDistinguishingStackTraceElement));
  }

  /**
   * @param firstDistinguishingStackTraceElement
   * @return String
   */
  private static String displayName(StackTraceElement firstDistinguishingStackTraceElement) {
    return Utils.getPropertyPath(firstDistinguishingStackTraceElement.getClassName(), firstDistinguishingStackTraceElement.getMethodName(),
        String.valueOf(firstDistinguishingStackTraceElement.getLineNumber()));
  }
}