class Product
{
    private final int idProduct;
    private final String name;
    private final String brand;
    private final double price;

    public Product(int idProduct, String name, String brand, double price)
    {
        this.idProduct = idProduct;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}

public class ProductRepositoryImpl implements ProductRepository
{
    private List<Product> listOfProducts = new ArrayList<Product>();

    public ProductRepositoryImpl()
    {
        addProduct(new Product(1, "Silnik", "Ferrari", 1000));
        addProduct(new Product(2, "Sprzęgło", "Opel", 500));
        addProduct(new Product(3, "Kierownica", "Fiat", 100));
        addProduct(new Product(4, "Panewka", "Maluch", 250.00));
        addProduct(new Product(5, "Akumulator", "Autosan", 1700.00));
        addProduct(new Product(6, "Zakrętka", "Maseratii", 100.00));
    }

    private void addProduct(Product product)
    {
        listOfProducts.add(product);
    }

    @Override
    public List<Product> getListOfProducts()
    {
        return listOfProducts;
    }
}