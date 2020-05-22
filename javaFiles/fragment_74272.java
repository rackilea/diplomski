try {
   ...
} catch (InterruptedException ie) {
   // re-interrupt the thread to propagate the interrupt flag
   Thread.currentThread().interrupt();
   // handle the interrupt here by probably quitting the thread
}