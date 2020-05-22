private static volatile int globalVal = 0;
private static Object lock = new Object();

public void writeInt(int val) {
    synchronized(lock) {
        while (globalVal != val) {
            try {
                lock.wait();
            }
            catch(InterruptedException e) {
            }
        }
        System.out.println(val);
        globalVal++;
        lock.notifyAll();
    }
}