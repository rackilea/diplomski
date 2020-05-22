public class ProductModel {
    private String productName;

    public ProductModel() {}

    public ProductModel(String productName) {this.productName = productName;}

    public String getProductName() {return productName;}

    @Override
    public String toString() { return productName; }
}