...
public void run() {
  xSpeed = 1;
  while(true) {
    synchronized(game) {
      while(game.isPaused().get()) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException iex) {
            // This most likely means your JVM stops. Maybe log the Exception.
            game.destroy();
            return;
         }
      }
      int x1 = ball.getX();
      int y1 = ball.getY();
      ...
      }
    }
  }
}