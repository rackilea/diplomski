ReentrantLock lock = new ReentrantLock();

    void method1()
    {
        if(lock.tryLock())
        {
           try {
             if (!(lock.getHoldCount() > 1)) {
               //do Some Stuff
             }
          } finally {
            lock.unlock();
          }
        }
    }