public class MyRunnable implements Runnable {

    private int count;

    public MyRunnable(int count) {
        this.count = count;
    }

    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("doMore(), count=" + count);
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable(1)).start();
        new Thread(new MyRunnable(2)).start();
        new Thread(new MyRunnable(3)).start();
        new Thread(new MyRunnable(4)).start();
    }
}