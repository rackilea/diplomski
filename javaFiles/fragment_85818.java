public void run()
{
    synchronized(syncObject) {
        // do some stuff
        syncObject.notify();
    }
}