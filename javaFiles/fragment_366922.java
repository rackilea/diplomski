public class Product {
  private String productName;

  public Product(String productName) {
    setProductName(productName); // for validation
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    if (productName == null || productName.length() == 0)
        throw new IllegalArgumentException("product name cannot be null or empty");
    this.productname = productName;
  }