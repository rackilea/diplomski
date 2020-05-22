try {
   Thread.sleep(1000);
} catch (InterruptedException e) {
   // i've been interrupted
   // catching InterruptedException clears the interrupt status on the thread
   // so a good pattern is to re-interrupt the thread
   Thread.currentThread().interrupt();
   // but maybe we want to just kill the thread
   return;
}