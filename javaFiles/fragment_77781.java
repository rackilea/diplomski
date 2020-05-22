public Predicate<Order> isReadyToDeliver() {
    Predicate<Order> orderState = o -> o.getState() == OrderState.READY_TO_SEND;

    Predicate<Order> productState =
                o -> o.getProducts()
                   .stream()
                   .map(Product -> Product.getState())
                   .allMatch(Product -> Product == ProductState.AVAILABLE);

    return orderState.and(productState);
}