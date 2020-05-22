public class Product extends PersistenceObject {
    private Category category;

    public Product() {
    }

    // ...

    public void initialize() {
        Db4oHelper helper = getDb4oHelper();
        // use the helper to perform whatever operations it needs
    }
}