public class Global {
  public static int time;
}

public class MultipleSleepingBarber implements Runnable {

  public void run() {
    Global.time = Global.time + 1;
    System.out.println("Time is " + Global.time);
  }

  public static void main(String args[]) {
    Global.time = 0;
    for (int i = 0; i < 10; i++)
      (new Thread(new MultipleSleepingBarber())).start();
  }

}