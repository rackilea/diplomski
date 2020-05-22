float hz = 5; // modulate at 5hz
       long budget = (long) ((1/hz) * 1000f);
       long loopDurationMs = 0;
       long loopStartMs = 0;
       while(true) {
           // calculate how long this loop took:
           long now = System.currentTimeMillis();
           loopDurationMs = now - loopStartMs;
           long sleepTime = budget - loopDurationMs;
           loopStartMs = now;
           if(sleepTime > 0) {
               try {
                   Thread.sleep(sleepTime);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }