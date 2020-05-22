public class SynchornizationMistakes {
    private static int count = 0;

    //locking on this object lock
    public synchronized int getCount(){
        return count;
    }

    //locking on .class object lock
    public static synchronized void increment(){
        count++;
    }

}