long delay = .... 
long next = System.currentTimeMillis();
while(running) {
     // do something
     next += delay;
     long sleep = next - System.currentTimeMillis();
     if (sleep > 0)
          Thread.sleep(sleep);
}