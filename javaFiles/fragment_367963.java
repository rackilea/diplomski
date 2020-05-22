CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Product> query = cb.createQuery(Product.class);

// "FROM Product p"
Root<Product> product = query.from(Product.class);
// "RIGHT JOIN store_has_product shp", "ON p.id_product=shp.id_product" is handled inside Product.class
Join<Product,StoreHasProduct> storeHasProduct = product.join(Product_.storeHasProductCollection);
// Create an alias to the shp.id_store column to use in the where condition
Path<Integer> id = storeHasProduct.get(StoreHasProduct_.storeHasProductPK).get(StoreHasProductPK_.storeidStore);
// "WHERE shp.id_store = 1"
query.where(cb.equal(id, 1));
// "SELECT p.*"
query.select(product);

TypedQuery<Product> tq = entityManager.createQuery(query);
for (Product p : tq.getResultList()) {
    // do stuff
}