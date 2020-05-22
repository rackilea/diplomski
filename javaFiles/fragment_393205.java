// Initialize an object
Product myProduct = new Product();
myProduct.lic = new Procuct.Licences();
myProduct.lic.total = totalObject;
myProduct.lic.used = usedObject;
myProduct.lic.remain = remainObject;


// Serialize the object into JSON
mapper.writeValue(new File("asset/testJson.json"), myProduct);