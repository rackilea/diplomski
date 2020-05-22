@Override
public void run() {
    try {
        locker.lock();
        for (int i = 0; i < 10; i++)
            counter += i;
        locker.unlock();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}