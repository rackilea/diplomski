@Test
public void testsTotalPriceAsSumOfProductPrices() {
    Products products = new Products(); // Or any appropriate constructor
    products.add(new Product("first", 10)); // Assuming such a constructor exists
    products.add(new Product("second", 20));
    products.add(new Product("second", 30));
    assertEquals("Sum must be eq to 60", 60, products.getTotalPrice());
}