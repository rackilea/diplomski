long timeout = 2000;
long timeoutExpires = System.currentTimeMillis() + timeout;
while(dosleep) {
  wait(timeout);
  if(System.currentTimeMillis() >= timeoutExpires) {
    // Get out of loop
    break;
  }
}