/**
 * define modifiable dog
 */
public class Dog {

    private ReadWriteLock _dogLock;
    private String _name;

    public Dog(ReadWriteLock dogLock) {
        _dogLock = dogLock;
    }

    public Lock dogChangesLock() {
        return _dogLock.writeLock();
    }

    public void setName(String name) {
        _dogLock.writeLock().lock();
        try {
            _name = name;
        } finally {
            _dogLock.writeLock().unlock();
        }
    }

    public String getName() {
        _dogLock.readLock().lock();
        try {
            return _name;
        } finally {
            _dogLock.readLock().unlock();
        }
    }
}

/**
 * holder class for dog handling
 */
public class Holder {

    private Dog _dog;

    /**
     * EURECA! this is what we want to use
     */
    private ReadWriteLock _dogLock = new ReentrantReadWriteLock();

    /**
     * get dog
     */
    public Dog getDog() {
        _dogLock.readLock().lock();
        try {
            if (_dog == null) {
                _dog = new Dog(_dogLock);
            }
            return _dog;
        } finally {
            _dogLock.readLock().unlock();
        }
    }

    /**
     * utilize dog :)
     */
    private void resetDog() {
        _dogLock.readLock().lock();
        try {
            _dog = null;
        } finally {
            _dogLock.writeLock().unlock();
        }
    }
}

/**
 * test class for simultaneous write/read
 */
public class Concurent {

    Holder holder = new Holder();

    /**
     * run concurrent threads
     */
    private void test() {

        /** thread for dog modification */
        new Thread(new Runnable() {

            /** thread to utilize dog :) */
            final Thread resetThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    holder.resetDog();
                }
            });

            /** main method */
            @Override
            public void run() {

                /** get dog */
                Dog dog = holder.getDog();

                /** get lock for write */
                dog.dogChangesLock().lock();

                try {

                    /** modifies dog */
                    dog.setName("Cat");

                    /** call to reset dog */
                    resetThread.start();

                    /**
                     * SAFE TO CALL SECOND TIME 
                     * we don't need to check if dog was altered 
                     * as we got write lock 
                     * */
                    dog.setName("Elephant");

                } finally {
                    dog.dogChangesLock().unlock();
                }
            }
        }).start();

    }
}