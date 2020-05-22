class ThreadHandler {
    private static final CIWTMOFactory defaultFactory = new CIWTMOFactory();
    private final CIWTMOFactory ciwtmoFactory;

    public ThreadHandler() {
        ciwtmoFactory = defaultFactory;
        ...
    }

    public ThreadHandler(CIWTMOFactory ciwtmoFactory) {
        this.ciwtmoFactory = ciwtmoFactory;
        ...
    }

    public void listen(...) throws ... {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ...
                executorService.submit(ciwtmoFactory.newInstance(socket));
                ...
            };
        ...
    }
...
}