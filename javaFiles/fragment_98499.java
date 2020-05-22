try {
     Thread.sleep(1000);
 } catch (InterruptedException e) {
     // always a good pattern to re-interrupt the thread here
     Thread.currentThread().interrupt();
     // if we are interrupted quit
     return;
 }