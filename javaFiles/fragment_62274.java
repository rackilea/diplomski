while( continueWork) {
    doSomeWork();
    if (Thread.interrupted()) {
        // We've been interrupted: no more crunching.
        return;
    }
}