class Product
{
    private String productName;
    private double price;
    private int quantity;
}

Class Store
{
   private String storeName;
   private List<Product> productList; //Product list can be retrieved from here
}

List<Store> storeList = new ArrayList<Store>();