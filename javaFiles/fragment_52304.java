class StaticClass {
  static private ThreadLocal<User> threadLocal = new ThreadLocal<>();

  static ThreadLocal<User> getThreadLocal() {
    return threadLocal;
  }
}