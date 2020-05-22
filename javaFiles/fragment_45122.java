long timeout = ....;
synchronized(obj) {
  long start = System.currentTimeMillis();
  while(!condition && (timeout > 0)) {
    obj.wait(timeout);
    long now = System.currentTimeMillis();
    timeout -= (now - start);
    start = now;
  }
}