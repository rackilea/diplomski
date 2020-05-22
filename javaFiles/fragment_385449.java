public class Product {

    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}

public class PromotedProduct extends Product {

    private Color color;

    public PromotedProduct(String name, BigDecimal price ,Color color) {
        super(name ,price);
        this.color = color;
    }
}

Product product[3];
product[0] = new Product("keyboard",100);
product[1] = new PromotedProduct("stick", 80 ,Color.RED);