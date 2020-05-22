Product product = new Product();
product.setId(1);

Manufacturer manufacturer = new Manufacturer ();
manufacturer.setId(123);
product.setManufacturer(manufacturer); // set Many-1 side of relationship

Set<Product> products = new HashSet<Product>();
products.add(product);
manufacturer.setProducts(products); // set 1-Many side of relationship