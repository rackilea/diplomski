TypedQuery<Product> q = em.createQuery("FROM Product WHERE productCode=:productCode", Product.class);
q.setParameter("productCode", productCode);
if(q.getResultList().isEmpty()) {
    return null;
}       
List<Product> results = q.getResultList();
Iterator<Product> i = results.iterator();
Product pp = null;
if(i.hasNext()) {
    pp = i.next();
}