public class Interceptor {
  public static void getter(@SuperCall Runnable zuper, @This Dirtiable self) {
    zuper.run();
    self.setDirty(true);
  }
}