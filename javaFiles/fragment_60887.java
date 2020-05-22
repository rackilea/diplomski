while (running && !Thread.interrupted()) {
    // do something that won't take long.
    try {
        Thread.sleep(1000L); // or some other 'wait a while' code.
    } catch (InterruptedException e) {
        return;
    }