public class Product {
    private String name;
    private String price; // maybe this should be a number

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}