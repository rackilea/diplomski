final Object signal = new Object();

// in the waiting thread
synchronized(signal) {
    signal.wait();
}

// in the signaling thread
synchronized(signal) {
    signal.notifyAll();
}