public void starterMeth() {
    Thread myThread = new MyThreadImpl(); // Create thread
    myThread.start(); // Start execution in parallel
}

public void stopMeth() {
    myThread.interrupt(); // Stop the thread
}