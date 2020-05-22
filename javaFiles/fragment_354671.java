public class ProductFactory extends Factory
{
    private static ProductFactory _instance;
    private HashMap m_RegisteredProducts = new HashMap();

    public static synchronized ProductFactory instance()
    {
        if (_instance == null)
            _instance = new ProductFactory();
        return _instance;
    }

    public void registerProduct(String productID, Product p)    {
        m_RegisteredProducts.put(productID, p);
    }

    public Product createProduct(String productID){
        ((Product)m_RegisteredProducts.get(productID)).createProduct();
    }
}