class SharedData {
    int c;
    boolean isOdd;
} 

class ThreadEvenOdd {
    SharedData sharedData;

    public ThreadEvenOdd(SharedData sd) { this.sharedData = sd }

    // ...

    void printOdd(int count) {
        try {
            for(int i=0;i<count/2;i++) {
                synchronized(sharedData) {
                    if(!sharedData.isOdd) { ... }
                    System.out.println(sharedData.c);
                    sharedData.c++;
                    sharedData.isOdd = false;
                    lock.notify();
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}