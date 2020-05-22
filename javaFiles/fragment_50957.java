public void run() {
  // do my work

  // This will block until supplier.set() returns
  originalCallbackSupplier.get().run();
}