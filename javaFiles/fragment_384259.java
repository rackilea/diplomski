public class Foo{
    //...

    public void consumeEvent() throws InterruptedException{
        aLock.lock();
        try {
            while(noEvent){
                eventAvailable.await();
            }
            // use the event
        } finally {
            sLock.unlock();
        }
    }

    public void createEvent() throws InterruptedException{
        aLock.lock();
        try {
            // add an event
            eventAvailable.signalAll();
        } finally {
            sLock.unlock();
        }
    }

    private Lock aLock = new ReentrantLock();
    private Condition eventAvailable = aLock.newCondition();
}