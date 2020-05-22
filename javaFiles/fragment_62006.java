public void enter(){
    lock.lock();
    try {
        while(isOccupied)
            unoccupied.await();
        isOccupied = true;
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
}


public void leave(){
    lock.lock();
    try {
        isOccupied = false;
        unoccupied.signal();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        lock.unlock();
    }
}