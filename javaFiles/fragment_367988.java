class Data{ 
    final Lock lock = new ReentrantLock();
    boolean dirty = false;

    public void setSomething(String a) {
        lock.lock();
        try {
            // modify the Data
            dirty = true;
        } finally {
            lock.unlock();
        }
    }

    public void backupData(Backup backup) {
       if (!lock.tryLock()) return;
       try {
           if (!dirty) return;

           backup.for(this);

           dirty = false;
       } finally {
           lock.unlock();
       }
    }