List<String> products = getProducts();/*your List of products*/

HashMap<String, Product> mergedProducts = new HashMap<String, Product>();
for(Product product : products){
    if(mergedProducts.containsKey(product.getCategory())){
        Product existingProduct = mergedProducts.get(product.getCategory());

        String newName = existingProduct.getName() + ", " + product.getName();
        int newPrice = existingProduct.getPrice() + product.getPrice();
        String newDesc = existingProduct.getDesc() + ", " + product.getDesc();

        existingProduct.setName(newName);
        existingProduct.setPrice(newPrice);
        existingProduct.setDesc(newDesc);
    } else {
        mergedProducts.put(product.getCategory(), product);
    }
}