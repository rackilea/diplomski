public synchronized void incrementCount() 
{
    int tmp = count + 1;
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    count=tmp;
}