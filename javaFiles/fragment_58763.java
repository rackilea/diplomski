public void run() {
    while(true) {
        EventQueue eq = getEventQueue();

        synchronized(eq) {
            while(eq.hasNextEvent()) {
                processOneEvent(eq.getNextEvent());
            }

            try {
                eq.wait();
            } catch(InterruptedException ie) {}
        }
    }
}