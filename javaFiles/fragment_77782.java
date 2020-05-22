public Function<Order, Boolean> isReadyToDeliver() {
    Function<Order, Boolean> orderState = o -> o.getState() == OrderState.READY_TO_SEND;

    Function<Order, Boolean> productState =
            o -> o.getProducts()
                    .stream()
                    .map(Product -> Product.getState())
                    .allMatch(Product -> Product == ProductState.AVAILABLE);


    return (order) -> orderState.apply(order) && productState.apply(order);
}