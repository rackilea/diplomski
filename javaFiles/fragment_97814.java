private static volatile int countSize = 0;
private static Object lock = new Object();


private static void addToSize(int i) {
    synchronized(lock) {
        countSize+=i;
    }
}
public static int getCount() {
    synchronized(lock) { //it is good practice to synch getters too - although not entirely necessary with ints.
        return countSize;
    }
}