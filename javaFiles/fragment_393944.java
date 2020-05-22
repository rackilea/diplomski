try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        // We've been interrupted, and returning from the run method will stop your thread.
        return;
    }