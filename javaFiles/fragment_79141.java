Map<String, Object> products = new HashMap<>();
List<Map<String, Object>> listProducts = new ArrayList<>();

for () { // Loop over products
    Map<String, Object> product = new HashMap<>();
    product.put("ProductTitleName", "YourTitle");
    product.put("ImageUrl", "YourImageUrl");
    listProducts.add(product);
}

products.put("products", listProducts);
// Now you can use products Map instead of an equivalent pojo class