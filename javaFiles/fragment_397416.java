class Engine implements Runnable {

    private final Object requestLock = new Object();
    private List<Request> requests = new LinkedList<Request>();
    private boolean running = true;

    private Request nextRequest() {
        synchronized(requestLock) { return requests.poll(); }
    }

    /**
     * The engine is single threaded. It doesn't care about server connections
     */
    public void run() {
        while(running) {
            Request request = nextRequest();
            // handle your request as normal
            // also consider making a mechanism to send Responses
        }
    }
}