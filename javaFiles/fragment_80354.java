Map<Product,Integer> myMap = new HashMap<Product,Integer>();

public List<Map.Entry<Product, Integer>> getProducts() {
    Set<Map.Entry<Product, Integer>> productSet = 
                     myMap.entrySet();
    return new ArrayList<Map.Entry<Product, Integer>>(productSet);
}