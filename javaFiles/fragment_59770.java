ReentrantLock lock1 = new ReentrantLock();
ReentrantLock lock2 = new ReentrantLock();

public void DoSomething()
{
    lock1.lock();
    lock2.lock();
    try {
         //critical section
    } finally {
         lock1.unlock();
         lock2.unlock();
    }    
}