result.put(new CreationParams(0, 0), new Supplier() {
    @Override
    public Result get() {
        return new FirstResult();
    }
});