MyClassLoader classLoader = new MyClassLoader(this.getClass().getClassLoader(), new MyClassLoaderListener() {
  public void classLoaded(Class<?> c) {
    System.out.println(c.getName());
  }
});
classLoader.loadClass(...);