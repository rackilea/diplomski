Product newProduct = new Product();
newProduct.setName(productName);
prodDir.getProdDir().put(newProduct);
System.out.println("You have entered Product"+ Arrays.toString(prodDir.getProdDir().toArray())); 
Sup.setProddirectory(prodDir);
System.out.println("Product List :"+ Arrays.toString(Sup.getProddirectory().getProdDir().toArray()));