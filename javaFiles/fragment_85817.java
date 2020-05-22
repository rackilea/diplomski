public void run()
{
    synchronized(thread1) {
        // do some stuff
        thread1.notify();
    }
}