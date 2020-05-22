public void run() {
    while (true) {

        // take() puts this thread to sleep until a writer calls add()
        int commitIndex = this.queue.take();

        // now the reader is awaken!
        while (lastApplied < commitIndex) {
            // do something with log.get(lastApplied)
            lastApplied++;
        }
    }
}