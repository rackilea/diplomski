public class ThreadsTest {

    public static void main(String[] args) throws Exception{
        ExtendsThread et = new ExtendsThread();
        et.start();
        Thread.sleep(1500);
        et.interrupt();
    }
}

class ExtendsThread extends Thread {
    public void run() {
        while (!isInterrupted()) {
        }
        System.out.println("ExtendsThread " + isInterrupted());
    }
}