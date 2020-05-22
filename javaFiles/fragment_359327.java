public void run() {
    while(true) {
        try {
            someOperationThatCanBeInterrupted();
        } catch (InterruptedException e) {
            cleanup(); //close files, network connections etc.
            Thread.currentThread().interrupt(); //restore interrupted status
        }
    }
}