public class Test  implements Runnable{

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Test());
        t.start();
        for (int i = 1 ; i <=500 ; i++)
            System.out.println("Main Thread printing "+i);
    }

    @Override
    public void run() {
        for (int i=501; i <=1000 ; i++) 
            System.out.println("Thread 1 printing "+i);
    } 
}