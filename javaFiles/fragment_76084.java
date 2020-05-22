public class MovementThread extends Runnable{

    private float[] myObject;
    volatile boolean stillAlive = true;

    @Override
    public void run() {
       while (stillAlive)
       {
          processMyObject();
          Thread.sleep(1000);
       }

    }

    private synchronized void processMyObject()
    {
       // Modify or read myObject
    }

    public void kill()
    {
       stillAlive = false;
    }  

    public synchronized void setMyObject(float[] array) {
        myObject = array;
    }
}