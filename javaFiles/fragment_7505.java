Task<Boolean> task = new Task<>() {

    @Override
    protected Boolean call() throws Exception {
        return false;
    }

    @Override protected void succeeded() {}
    @Override protected void cancelled() {}
    @Override protected void failed() {}

});