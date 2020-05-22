package ingredient;

public class Ingredient {

    private final String name;
    private final double price;

    public Ingredient(String ingr_name, double ingr_price) {
        name = ingr_name;
        price = ingr_price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}