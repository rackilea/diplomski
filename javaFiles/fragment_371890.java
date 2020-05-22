final FutureTask query = new FutureTask(new Callable() {
    @Override
    public Object call() throws Exception {
        return queryPassword();
    }
});
Platform.runLater(query);
System.out.println(query.get());