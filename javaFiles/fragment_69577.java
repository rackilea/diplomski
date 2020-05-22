public final class Builder {

    private String color;
    private int price;

    public Builder() {
        // Assign any default values
    }

    public Builder color(String color) {        
        this.color = color;
        return this;
    }

    public Builder price(int price) {        
        this.price = price;
        return this;
    }

    protected String getColor() {
        return color;
    }

    protected int getPrice() {
        return price;
    }

    public Product build() {
        return new Product(this);
    }
}