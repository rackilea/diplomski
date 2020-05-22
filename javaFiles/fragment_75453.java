List<Product> products = entityManager
.createQuery(
    "SELECT p " +
    "FROM Product p " +
    "ORDER BY p.created_on DESC", Product.class)
.setMaxResults( 50 )
.getResultList();