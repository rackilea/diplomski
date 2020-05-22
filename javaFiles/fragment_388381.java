import java.util.ArrayList;

public class Main extends Thread {
ArrayList<Thread> threads;
volatile static boolean ACTIVE = true;
public Main() {
    super();
    threads = new ArrayList<Thread>();
}

 public void run(){

Object monitor = new Object();
for (int i = 0; i <= 5; i++) {
  threads.add(new Thread(new Task(i + 65, monitor)));
}

long cT = System.currentTimeMillis();
for (int i = 0; i < threads.size(); i++) {
  threads.get(i).start();
}
try{Thread.sleep(50);}catch(Exception e){e.printStackTrace();}
 //   System.out.println("BEFORE synchronized(monitor)");
synchronized(monitor){
  while (System.currentTimeMillis() - cT < 1000) {
      try{

    monitor.notify();
    Thread.sleep(500);

    monitor.wait();}catch(Exception e){e.printStackTrace();}
  }
   //    System.out.println("BEFORE ACTIVE= FALSE and after WHILE in Main");
  ACTIVE = false;
  for(int i  = 0; i < threads.size(); i++){
      System.out.println(threads.get(i).getState());
  }


}
System.out.println("LAST COMMAND IN MAIN");

  }


  public static void main(String[] args) {
     new Main().start();
    //new Thread(new Task(65)).start();

}

}