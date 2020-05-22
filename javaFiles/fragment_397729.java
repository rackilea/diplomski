private HashMap<String, ArrayList<Product>> sortProductsByCategory (ArrayList<Product> arrayList) {

    HashMap<String, ArrayList<Product>> map = new HashMap<String, ArrayList<Product>>();

    for(Product product: arrayList) {

        // If the key does not exist in the hashmap
        if(!map.containsKey(product.getCategory().getName())) {
            ArrayList<Product> listInHash = new ArrayList<Product>();
            listInHash.add(product);
            map.put(product.getCategory().getName(), listInHash);
        } else {
            // add the product to the arraylist that corresponds to the key
           ArrayList<Product> listInHash = map.get(product.getCategory().getName());
           listInHash.add(product);

        }

    }

    return map;

}