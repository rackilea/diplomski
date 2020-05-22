class ReflectionSupplier implements Supplier {
    final Class<? extends Result> clazz;

    ReflectionSupplier(final Class<? extends Result> clazz) {
        this.clazz = clazz;
    }

    public Result get() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Error(e);
        }
    }
}