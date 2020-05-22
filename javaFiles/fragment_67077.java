public class Buffer
{
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition(); 
    final Condition notEmpty = lock.newCondition(); 

    // `volatile` isn't needed for objects accessed under critical section
    private String content = "";
    private boolean isEmpty = true;

    // Use lock instead of `synchronized`.
    public void addItem(String s)
    {
        lock.lock();
        try {
            while(!isEmpty){
                try {
                    notFull.await(); // Analogue for wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            content = s;
            isEmpty = false;
            notEmpty.signal(); // Analogue for notify()
        } finally {
            lock.unlock();
        }    
    }

    // Use lock instead of `synchronized`.
    public String getItem()
    {
        lock.lock();
        try {
            while(isEmpty) {
                try {
                    notEmpty.await(); // Analogue for wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            String temp = content;
            isEmpty = true;
            notFull.signal(); // Analogue for notify()
            return temp;
        } finally {
            lock.unlock();
        }    
    }
}