public synchronized void reStart()
{
// here the method is executed twice as I described in step 7
// after notify() it actually jumps back to stopTimer=false again and then exits the function. Then outside of this object I catch RuntimeException 
    stopTimer=false;
    synchronized(timer) {
        timer.notify();
    }
}

public synchronized void resume()
{
    pauseTimer=false;
    synchronized(timer) {
        timer.notify();
    }
}