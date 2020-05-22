public class Main implements Runnable { 

    @Override
    public void run() {
        System.out.println("New thread");
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
        System.out.println("Main thread");
    }
}