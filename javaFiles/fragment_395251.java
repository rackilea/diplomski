@Test
public void saveTest() {
    ProductInfo productInfo = new ProductInfo();
    productInfo.setProductId("123456");
    productInfo.setProductName("皮蛋粥");
    productInfo.setProductPrice(new BigDecimal(3.2));
    productInfo.setProductStock(100);
    productInfo.setProductDescription("很好喝的粥");
    productInfo.setProductIcon("http://xxxxx.jpg");
    productInfo.setProductStatus(0);
    productInfo.setCategoryType(3);

    // Insert new product.
    repository.persist(productInfo);
}