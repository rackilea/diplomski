Future<Void> future = ex.submit(new Callable<Void>() {
    public Void call() throws SpecificException {
        // do something which might throw SpecificException
        return null;
    }
});