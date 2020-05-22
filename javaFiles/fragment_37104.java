final FooBar obj = new FooBar();

// calling obj.foo()
synchronized(obj) { // 1. here the lock is acquired, the counter is set to 1

    // do some foo-work

    // calling obj.bar()
    synchronized(obj) {  // 2. the same lock object, the counter is set to 2
        // do the bar-work
    } // 3. the counter is set to 1, the lock is still not released

    // continue doing the foo-work
} // 4. the counter is 0, the lock is released