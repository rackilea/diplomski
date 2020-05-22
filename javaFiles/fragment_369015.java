public class SynchronizeTest implements Runnable{

    public synchronized void methodA() throws InterruptedException {
        System.out.println("calling method a ...");
        Thread.sleep(2000);
        System.out.println("ending method a");
        this.notify();
    }

    public synchronized void methodC() throws InterruptedException {
        System.out.println("calling method C");
        new Thread(new Runnable() {
            @Override
            public void run() {
                methodA();
            }
        }).start();
        this.wait();
        System.out.println("end method C");
    }

    public static void main(String[] args) throws InterruptedException {
        new Test().methodC();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}