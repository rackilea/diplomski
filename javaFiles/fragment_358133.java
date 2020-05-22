public class SessionAttributeTracker implements HttpSessionAttributeListener
{

  private static final Logger logger = LoggerFactory.getLogger(SessionAttributeTracker.class);

  @Override
  public void attributeAdded(final HttpSessionBindingEvent sessionBindingEvent)
  {
    Object obj = sessionBindingEvent.getValue();
    logger.debug("Session attribute added: {}", obj);
    if (!isSerializable(obj))
    {
      logger.warn("Attribute '{}' added to session with non-serializable object: {}",
          sessionBindingEvent.getName(),
          sessionBindingEvent.getValue());

    }
  }

  private boolean isSerializable(final Object obj)
  {
    logger.debug("Checking serializability of : {}", obj.getClass().getName());
    boolean ret = false;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream oos = null;
    try
    {
      oos = new ObjectOutputStream(out);
      oos.writeObject(obj);
      ret = true;
    }
    catch (Exception e)
    {
      for (Field f : obj.getClass().getDeclaredFields())
      {
        logger.trace("obj {} felt {}", obj, f.getName());
        if ((f.getModifiers() & Modifier.TRANSIENT) == 0)
        {
          f.setAccessible(true);
          try
          {
            Object object = f.get(obj);
            oos = new ObjectOutputStream(out);
//          logger.debug("Hopper over writeObject");
            oos.writeObject(object);
          }
          catch (Exception e1)
          {
            logger.debug("Problem encountered while serializing attribute {}", f.getName(), e1);
          }
        }
      }
      logger.warn("Serilization problem.", e);
      return ret;
    }
    finally
    {
      IOUtils.closeQuietly(oos);
    }
    return ret;
  }

  private String threadDump()
  {
    StringBuffer fullThreadDump = new StringBuffer();
    Thread t = Thread.currentThread();
    State state = t.getState();
    String tName = t.getName();
    if (state != null)
    {
      fullThreadDump.append("   ").append(tName).append(": ").append(state).append("\n");
    }
    StackTraceElement[] stes = t.getStackTrace();
    for (StackTraceElement stackTraceElement : stes)
    {
      fullThreadDump.append("     at ").append(stackTraceElement).append("\n");
    }

    return fullThreadDump.toString();
  }

  @Override
  public void attributeRemoved(final HttpSessionBindingEvent sessionBindingEvent)
  {
  }

  @Override
  public void attributeReplaced(final HttpSessionBindingEvent sessionBindingEvent)
  {
  }

}