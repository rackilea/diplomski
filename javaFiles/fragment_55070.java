public static class ProductStorage {
    private Product product;
    private int getTimes;

    public ProductStorage(Product product, int getTimes) {
        this.product = product;
        this.getTimes = getTimes;
    }
}

public static class Factory {
    private static final int REUSABLE_TIMES_LIMIT = 10;
    private static AtomicReference<ProductStorage> instance = new AtomicReference<>(
            new ProductStorage(new Product(), 0)
    );

    public static Product getInstance() {
        ProductStorage current;
        for(;;) {
            current = instance.get();
            if(current.getTimes >= REUSABLE_TIMES_LIMIT) {

                instance.compareAndSet(current, new ProductStorage(new Product(), 0));
                continue;
            }
            if(current.getTimes < REUSABLE_TIMES_LIMIT) {

                if(instance.compareAndSet(current, new ProductStorage(current.product, current.getTimes + 1))) {
                    return current.product;
                }
            }
        }
    }
}