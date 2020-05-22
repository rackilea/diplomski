public void asyncCallODBC() {
    // wrap the call with a runnable task
    executor.execute(new Runnable() {

        @Override
        public void run() {
            callODBC();
        }
    });
    // the above line would return immediately.
}