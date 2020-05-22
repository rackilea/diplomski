Object lock = new Object();
try
{
    synchronized(lock) {
        System.out.println("holding lock: "+Thread.holdsLock(lock));
        throw new OutOfMemoryError();
    }
}
catch(Throwable t) // just for demonstration
{
    System.out.println(t+" has been thrown, holding lock: "+Thread.holdsLock(lock));
}