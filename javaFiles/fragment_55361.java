public class Product {

    private long id;
    private String name;
    private List<ProductMedia> mediaList;


    public Product() {
        mediaList = new ArrayList<ProductMedia>();
    }

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
        mediaList = new ArrayList<ProductMedia>();
    }
    // getters + setters
}