private static void addProductsWithPrices(Products products, Double...prices){
  for(Double price : prices){
     //could keep static counter or something
     //to make names unique
     products.add(new Product("name", Currency.valueOf(price)));
  }
}