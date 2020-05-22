public class Product{
    private int id;
    private String productName;
    private int quantitiy;

    // add getters setters here
}

// add product id to map key
Map<Integer,Product> myMap = new HashMap<Integer,Product>();

public Map<Integer,Product> getProductMap() {
   return myMap;
}


public List<Product> getProducts() {
   return new ArrayList<Product>(myMap.values()_;
}