private void runInPluginContext(ContextCallback callback) {
  ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
  Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
  callback.call();
  Thread.currentThread().setContextClassLoader(oldCl);
}

interface ContextCallback {

  void call();

}