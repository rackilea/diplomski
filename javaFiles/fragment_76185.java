for(OrderItem item : orderItems) {
    Optional<String> prod = Optional.ofNullable(item)
            .map(OrderItem::getProduct)
            .map(Product::getProductName)
            .filter(s -> s.equals(prodName));

    if (prod.isPresent()) {
        return true;
    }
}
return false;