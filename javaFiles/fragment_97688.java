// in a loop determined by if the thread is still alive
    while (msgThread.isAlive()) {

        // wait a max of 1 second for thread to finish
        msgThread.join(1000);

        // if the amount of time passed is more than patience and the
        // thread is still alive
        if ((System.currentTimeMillis() - startTime > patience) &&
            msgThread.isAlive()) {

            // "tired of waiting" to threadMessage
            threadMessage("Tired of waiting, ending thread.");
            // interrupt the thread
            msgThread.interrupt();
            // wait indefinitely for it to finish
            msgThread.join();
        }
    }