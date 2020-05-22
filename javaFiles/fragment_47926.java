Product myProduct = new Product(); // <-- a reference to a product.
myProduct.setName("Pen");
myProduct.setPrice(1.25);
myProduct.setQuantity(50);
myInventory.addProduct(myProduct); // <-- a copy of the reference.

myProduct = new Product(); // <-- create a new product.
// now you have a second product....
myProduct.setName("Paper");
myProduct.setQuantity(500);
myProduct.setPrice(12.85);
myInventory.addProduct(myProduct);