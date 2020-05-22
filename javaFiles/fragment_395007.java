timer.scheduleAtFixedRate(new TimerTask() {
   public void run() {
      if( pauseCount == 10 ) {
         ball.reset(width/2, height/2);
      }
      if( pauseCount > 0 ) {
         --pauseCount;
      }
      else {
         ball.autoMove( velocityX, velocityY );
         collisionCheck();
      }
   }
}, initialDelay, 100 );