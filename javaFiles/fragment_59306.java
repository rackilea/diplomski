int processors = Runtime.getRuntime().availableProcessors();
for(int i=0; i < processors; i++) {
  Thread yourThread = new AThreadYouCreated();
  // You may need to pass in parameters depending on what work you are doing and how you setup your thread.
  yourThread.start();
}