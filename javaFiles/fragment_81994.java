class ClassPathChecker {
  private final ClassLoader classLoader;
  ClassPathChecker() { this(ClassLoader.getSystemClassLoader()); }
  ClassPathChecker(ClassLoader classLoader) {
   this.classLoader = this.classLoader);
  }

  boolean canClassBeLoaded(String className) {
    try {
      classLoader.loadClass ...