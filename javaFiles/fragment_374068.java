public class SampleTask extends TimerTask {
  Thread myThreadObj;
  SampleTask (Thread t){
   this.myThreadObj=t;
  }
  public void run() {
   myThreadObj.start();
  }
}