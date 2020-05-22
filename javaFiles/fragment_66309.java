private List<Product> fromJsonNode(JsonNode node) {
    String[] names = node.get("name").textValue().split(",");
    // create list of known size
    List<Product> products = new ArrayList<>(ids.length);
    // these values will remain the same for all products
    ProductBuilder builder = Product.builder()
                                    .price(node.get("price").numberValue())
                                    .sku(node.get("sku").textValue());
    for (String name : names) {
        // just set the name and create the product with it
        products.add(builder.name(name).build());
    }
    return products;
}