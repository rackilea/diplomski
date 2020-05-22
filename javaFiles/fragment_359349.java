Thread 1:
public void run(){
   for(Ball b : ballList){
      b.move();
      b.repaint();
   }
}

Thread 2:
public void run(){
   for(Ball b : ballList){
      b.move();
      b.repaint();
   }
}

Thread N:
public void run(){
   for(Ball b : ballList){
      b.move();
      b.repaint();
   }
}