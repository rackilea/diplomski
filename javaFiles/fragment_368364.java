public void run() {
    while (!Thread.currentThread().isInterrupted() {
        ...
    }
}

...

th.interrupt();