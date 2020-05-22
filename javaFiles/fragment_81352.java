final class HelperWrapper {
  private static final class DeferredLoader {
    public static final Helper HELPER_INSTANCE = new Helper();
  } 

  public static Helper getHelper() {
    return DeferredLoader.HELPER_INSTANCE;
  }
}