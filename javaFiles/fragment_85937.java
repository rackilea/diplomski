class ClassName {
  public void static synchronized staticMethodA() {
    doStaticStuff();
  }
  public static void staticMethodB() {
    synchronized(ClassName.class) {
      doStaticStuff();
    }
  }
  public void nonStaticMethodC() {
    synchronized(this.getClass()) {
      doStuff();
    }
  }
  public static void unSafeStaticMethodD() {
   doStaticStuff();
  }
}