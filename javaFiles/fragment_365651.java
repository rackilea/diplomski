public class MyDaemon implements Runnable {
     private volatile boolean running = false;

     public void setRunning(boolean isRunning){
          this.running = isRunning;
     }

     public boolean isRunning(){
          return running ; 
     }

     public void run(){
          **running = true;**
          while(running){
              // your code here
          }

     }
 }