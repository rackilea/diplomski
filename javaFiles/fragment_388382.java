public class Task implements Runnable {
int nr;
char character;
Object monitor;

public Task(int literaASCII, Object monitor) {
    this.nr = 0;
    this.monitor = monitor;
    character = (char) (literaASCII);
}

@Override
public void run() {
    synchronized (monitor) {
        while (Main.ACTIVE) {
            try {
//               System.out.println("ENTERING WHILE IN TASK");
                monitor.wait();
                System.out.print(nr + "" + character + ", ");
                nr++;
                int r = (int) ((Math.random() * 50) + 50); // <500ms,1000ms)

                Thread.sleep(r);
            } catch (Exception e) {e.printStackTrace();}
            monitor.notify();
    //       System.out.println("YYYYYYYYY");
        }
         System.out.println("AFTER WHILE IN Task");
    }
    System.out.println("I am saying goodbye " + character);
}