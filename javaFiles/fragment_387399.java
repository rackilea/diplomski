CompletionService<Image> service = new ExecutorCompletionService<Image>(
  Executors.newFixedThreadPool(nThreads));
for (Image image : images) {
  service.submit(new ImageRunnable(image), image);
}
try {
  for (int i = 0; i < images.size(); i++) {
    service.take();
  }
} catch (InterruptedException e) {
  // someone wants this thread to cancel peacefully; either exit the thread
  // or at a bare minimum do this to pass the interruption up
  Thread.currentThread().interrupt();
}