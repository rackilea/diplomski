void run() {
  synchronized(lock) {
    lock.wait(); //wait() will throw InterruptedException here
  }
}
//from another thread
myThread.interrupt();`