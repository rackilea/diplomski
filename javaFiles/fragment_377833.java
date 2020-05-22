public class ApplicationContextUtils {

  private static final AtomicReference<ApplicationContext> context = 
    new AtomicReference<ApplicationContext>();

  public static ApplicationContext getContext() {
    ApplicationContext ctx = context.get();
    if (ctx == null)
      throw new IllegalStateException();
    return ctx;
  }

  public static boolean isInitialized() {
    return context.get() == null;
  }

  static void setContext(final ApplicationContext ctx) {
    if (ctx == null) 
      throw new IllegalArgumentException();
    if (!context.compareAndSet(null, ctx))
      throw new IllegalStateException();
  }

  public static <T> T getBean(final String name, final Class<T> type) {
    if (type == null) 
      throw new IllegalArgumentException();
    return type.cast(getContext().getBean(name, type));
  }

  private ApplicationContextUtils() {
    throw new AssertionError();
  }

}