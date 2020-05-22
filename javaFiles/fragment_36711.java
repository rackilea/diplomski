public class Category {

    @Id
    private ObjectId id;

    private String category_name;

    @DbRef
    private List<Product> products_ids;

    // ... getters and setters ...

}

public class Product {

    @Id
    private ObjectId id;

    private String product_name;

    @DbRef
    private List<Category> categories_ids;

    // ... getters and setters ...

}