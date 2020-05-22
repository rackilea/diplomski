public My_Product createProduct(String type, String name) {
    Furniture cachedproduct = map.get(type);
    Furniture clonedProduct = (Furniture) cachedproduct.clone();
    clonedProduct.setType(type);
    clonedProduct.setName(name);
    return clonedProduct;
}