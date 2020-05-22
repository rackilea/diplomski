final Object lock = new Object();

public void write(...){
  synchronized(lock){
    // do writing
  }
}