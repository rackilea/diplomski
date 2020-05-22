public void SomeClass {
    private Object lock = new Object();
    private SomeState state;

    public void mutateSomeSharedState() {
        synchronized(lock) {
            //mutate some state
        }
    }

    public SomeState readState() {
        synchronized(lock) {
            //access state
        }
    }
}