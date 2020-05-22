private Runnable clearRequests = new Runnable() { 

    public void run() {
        try {
             // Here do your task
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
};