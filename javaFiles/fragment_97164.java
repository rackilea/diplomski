Thread thread = new Thread(myRunnableCode);
thread.start();
thread.join(timeoutMs);
if (thread.isAlive()) {
  thread.interrupt();
}