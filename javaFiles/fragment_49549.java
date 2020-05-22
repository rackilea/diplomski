public class Product extends RealmObject
{
    @PrimaryKey
    private int prodId;

    @Required
    private String name;

    private RealmList<ProductItem> productItems;

    //@LinkingObjects("productParent")
    //private final RealmResults<ProductItem> linkProductItems = null;
    ...
    ...
    ...
}

public class ProductItem extends RealmObject
{
    @PrimaryKey
    private String primaryKey;

    private int prodId;

    private int prodItemId;

    private String itemCode;

    private double price;

    //private Product productParent;    

    @LinkingObjects("productItems")   // <-- !
    private final RealmResults<Product> productParents = null; // <-- !
    ...
    ...
    ...
    public RealmResults<Product> getProductParents() // <-- !
    {
        return productParents;
    }
}