public class MyThread extends Thread {

   public void run(){
      Process p=Runtime.getRuntime().exec("/home/yoganandhd/project.sh");
      p.waitFor();
   }
}