public class Product {
    int id;
    String name;

    @JsonFilter("productView")
    List<Product> similarProducts;

    // getters and setters
}