private static class MovingRunnable implements Runnable{
   private final Ball b;
   private MovingRunnable(Ball b){this.b=b;}
   public void run(){
      for(;;){
         b.move(); 
         b.repaint();
         Thread.sleep(20);
      }
   }
}