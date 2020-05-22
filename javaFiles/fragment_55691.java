import java.io.*;
public class ConsoleProgressBar {
    public static void main(String[] argv) throws Exception{
      System.out.println("Rotating progress bar");
      ProgressBarRotating pb1 = new ProgressBarRotating();
      pb1.start();
      int j = 0;
      for (int x =0 ; x < 2000 ; x++){
        // do some activities
        FileWriter fw = new FileWriter("c:/temp/x.out", true);
        fw.write(j++);
        fw.close();
      }
      pb1.showProgress = false;
      System.out.println("\nDone " + j);

      System.out.println("Traditional progress bar");
      ProgressBarTraditional pb2 = new ProgressBarTraditional();
      pb2.start();
      j = 0;
      for (int x =0 ; x < 2000 ; x++){
        // do some activities
        FileWriter fw = new FileWriter("c:/temp/x.out", true);
        fw.write(j++);
        fw.close();
      }
      pb2.showProgress = false;
      System.out.println("\nDone " + j);
    }
}

class ProgressBarRotating extends Thread {
  boolean showProgress = true;
  public void run() {
    String anim= "|/-\\";
    int x = 0;
    while (showProgress) {
      System.out.print("\r Processing " + anim.charAt(x++ % anim.length()));
      try { Thread.sleep(100); }
      catch (Exception e) {};
    }
  }
}

class ProgressBarTraditional extends Thread {
  boolean showProgress = true;
  public void run() {
    String anim  = "=====================";
    int x = 0;
    while (showProgress) {
      System.out.print("\r Processing " 
           + anim.substring(0, x++ % anim.length())
           + " "); 
      try { Thread.sleep(100); }
      catch (Exception e) {};
    }
  }
}