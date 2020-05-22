public static final ReentrantLock lock = new ReentrantLock(true);
public static void i()
{
    lock.lock();
    try {
        System.out.println(Thread.currentThread().getName());

    } finally {
        lock.unlock();
    }
}