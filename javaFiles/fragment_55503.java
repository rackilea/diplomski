// get relevant jar urls
URL[] urls = ...;

ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();
try {
  URLClassLoader loader = new URLClassLoader(urls);
  Thread.currentThread().setContextClassLoader(loader);

  Class<?> entryClass = loader.loadClass("entry.class.name");
  // do something here w/ entryClass (e.g. instantiate it) ...

} finally {
  Thread.currentThread().setContextClassLoader(oldLoader);
}