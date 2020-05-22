public void run()
{
    synchronized(myObject) {
        // do some stuff
        myObject.notify();
    }
}