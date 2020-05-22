private int someMethod1Invocations = 0;
private int someMethod2Invocations = 0;

public void someMethod1() {
    synchronized(this) {
        // Wait for there to be no someMethod2 invocations -- but
        // don't wait on any someMethod1 invocations.
        // Once all someMethod2s are done, increment someMethod1Invocations
        // to signify that we're running, and proceed
        while (someMethod2Invocations > 0)
            wait();
        someMethod1Invocations++;
    }

    // your code here

    synchronized (this) {
        // We're done with this method, so decrement someMethod1Invocations
        // and wake up any threads that were waiting for that to hit 0.
        someMethod1Invocations--;
        notifyAll();
    }
}

public void someMethod2() {
    // comments are all ditto the above
    synchronized(this) {
        while (someMethod1Invocations > 0)
            wait();
        someMethod2Invocations++;
    }

    // your code here
    synchronized(this) {
        someMethod2Invocations--;
        notifyAll();
    }
}