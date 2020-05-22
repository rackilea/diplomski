public class threadtest extends Thread {
    public void run() {
        System.out.println("running thread name is:" + Thread.currentThread().getName());
        System.out.println("running thread priority is:" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        threadtest tt = new threadtest();
        tt.setPriority(MAX_PRIORITY);
        threadtest tt1 = new threadtest();
        tt1.setPriority(MIN_PRIORITY);
        tt1.start();
        tt.start();
    }
}