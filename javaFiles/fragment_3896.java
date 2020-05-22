class A {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Foo foo = new Foo();
    Foo getFoo() {
        lock.readLock().lock();
        try {
            Foo tmp = foo; //foo.clone()?
        } finally {
            lock.readLock().unlock();
        }
        return tmp;
    }
    void modifyFoo() {
        lock.writeLock().lock();
        try {
            //modify this.foo
            //...
        } finally {
            lock.writeLock().unlock();
        }
    }
}