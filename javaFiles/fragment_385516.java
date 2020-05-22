public class Monitor {

    private final Object lock = new Object();
    private int expectedId = 0;

    public void print(int id, int num) {
        synchronized (lock) {
            while (id != expectedId) {
                try {
                    lock.wait();
                }
                catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println("id=" + id + " num=" + num);
            expectedId++;
            lock.notifyAll();
        }
    }
}