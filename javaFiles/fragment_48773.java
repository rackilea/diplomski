class ToStringSupplier<T> {
    private Supplier<T> supplier;

    public ToStringSupplier(Supplier<T> supplier){
        this.supplier = supplier;
    }

    public static <T> ToStringSupplier<T> lazily(Supplier<T> supplier){
        return new ToStringSupplier<>(supplier);
    }

    @Override
    public String toString(){
        return Objects.toString(supplier.get());  // supplier could safely return null
    }
}