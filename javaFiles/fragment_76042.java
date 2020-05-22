public void doSomethingWithLocks() {
     doSomethingWithLock(0);
}

private void doSomethingWithLock(int stripe) {
     if (stripe < stripes.size()) {
         Lock lock = stripes.getAt(stripe);
         lock.lock();
         try {
             doSomethingWithLock(stripe + 1);
         } finally {
             lock.unlock();
         }
     } else {
         doSomething();
     }
}

private void doSomething() {
    // Do something
}