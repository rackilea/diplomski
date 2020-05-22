@Test
public void testsTotalPriceAsSumOfProductPrices() {
    Products products = new Products(); 

    addProductsWithPrices(products, 10,20,30);

    assertEquals(60, products.getTotalPrice());

}

private static void addProductsWithPrices(Products products, Double...prices){
  for(Double price : prices){
     //could keep static counter or something
     //to make names unique
     products.add(new Product("name", price));
  }
}