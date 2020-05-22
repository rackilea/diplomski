public String get() {
  try {
    return unprocessed.take();
  } catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    return "";
  }
}