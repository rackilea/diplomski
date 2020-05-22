public class SingletonDemo {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

    final CyclicBarrier gate = new CyclicBarrier(3);

    Thread t1 = new Thread() {
        public void run() {
            try {
                gate.await();
                Singleton.getInstance();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    };
    Thread t2 = new Thread() {
        public void run() {
            try {
                gate.await();
                Singleton.getInstance();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    };

    t1.start();
    t2.start();
    gate.await();
    }
}