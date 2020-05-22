public class Product {

    private int id;
    private String name;
    private float defaultPrice;
    private Currency defaultCurrency;
    private Supplier supplier;
    private static List<Product> productList = new LinkedList<>();
    private ProductCategory productCategory;

    public Product(float defaultPrice, Currency defaultCurrency, String name){
        this.id = IdGenerator.createID();
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = defaultCurrency;
        this.name = name;
        productList.add(this);
    }
}