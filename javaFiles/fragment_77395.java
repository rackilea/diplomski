session.beginTransaction();

Product product = new Product();
product.setName("Coffee");
session.save(product);

ProductOption po2 = new ProductOption();
po2.setTopping("barbeque");
po2.setProduct(product)
ProductOption po = new ProductOption();
po.setTopping("whipcream");
po2.setProduct(product)
ProductOption po1 = new ProductOption();
po1.setTopping("honeymustard");
po2.setProduct(product)

session.save(po2);
session.save(po);
session.save(po1);

session.getTransaction().commit();
session.close();