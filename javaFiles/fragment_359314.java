public class Closing implements Runnable{
    Scanner s = new Scanner(System.in);
    public void run() {

        while (s.next().equals("stop")){
            System.out.println("Threads down");

            Task.keepRun =false;

            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){} 
        };
    }
}