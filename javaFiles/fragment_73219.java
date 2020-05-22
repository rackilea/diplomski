@Override
public List<Product> getProductsByName(String name) {
  Query q = em.createQuery("SELECT p FROM Product p WHERE p.productName LIKE :name")
  q.setParameter("name", '%'+name+'%');
  @SuppressWarnings("unchecked")
  List<Product> pro = q.getResultList();
  return pro;
}