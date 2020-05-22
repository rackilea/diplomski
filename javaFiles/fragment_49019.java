Map<String, Map<Product, Integer>> zipCodeProducts = new HashMap<>();
for (Customer customer: customers) {
    Map<Product,Integer> productCounts = zipCodeProducts.computeIfAbsent(customer.getZipCode(), () -> new HashMap<>());
    for (Purchase purchase: customer.getItems()) {
        productCounts.merge(purchase.getProduct(), 1, Integer::sum);
    }
}