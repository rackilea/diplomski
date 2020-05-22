public class Main extends Thread {

    @Override
    public synchronized void run() {
       super.run();
       try {
           this.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    } 

    public static void main(String[] args) {
        new Main().start();
        System.out.println("hello");
    }
}