public class BreakPointPlay {

static int breakpointHits;

static volatile int modifiedBySecondThread;

static volatile boolean stopped;

public static void main(String[] args) throws InterruptedException {

    Thread secondThread = startSecondThread();

    final long LOOPS = 1000;
    long counter = 0;
    long start = System.nanoTime();
    for (long i = 0; i < LOOPS; i++) {

        // place breakpoint here and set the condition to the
        // #breakPointCondition() method.
        counter += i;

    }
    long stop = System.nanoTime();
    long nanos = stop - start;
    long micros = nanos / 1000;

    System.out.println("\nDuration: " + micros + " microseconds\n");

    printInfo();
    stopped = true;

    secondThread.join();
}

private static Thread startSecondThread() {
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(! stopped){
                modifiedBySecondThread++;
            }
        }
    });
    thread.start();
    return thread;
}

private static void printInfo() {
    printModifiedBySecondThread();
    printThread();
    printClassLoader();
    printStackTrace();
    printModifiedBySecondThread();
}

private static void printStackTrace() {
    Exception exception = new Exception();
    exception.fillInStackTrace();
    exception.printStackTrace(System.out);
}

private static void printModifiedBySecondThread() {
    print("modifiedBySecondThread " + modifiedBySecondThread);
}

public static boolean breakPointCondition(){
    breakpointHits++;
    if(breakpointHits == 100){
        printInfo();
    }
    return false;
}

private static void printClassLoader() {
    print("ClassLoader " + new BreakPointPlay().getClass().getClassLoader());
}

private static void printThread() {
    print("Thread " + Thread.currentThread());
}

private static void print(String msg){
    System.out.println(msg);
}


}