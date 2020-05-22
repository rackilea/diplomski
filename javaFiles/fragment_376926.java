public static List<Product> findActiveByFilter(ArrayList<FilterPair> filters) {
    List<Product> products = getCachedAllProductsByFirstSupplier();

    if (products == null) {
        products = new ArrayList<Product>();
    }

    if(filters.size() > 0) {
        List<Product> productsFiltered = new ArrayList<Product>(products);
        // ... MANY checks here for the filters ...

        return productsFiltered;
    }

    return new ArrayList<Product>(products); // Do not give cached copy, was 'return products;'
}