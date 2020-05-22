interface Food
{
    float getPrice();
}

public enum Fry implements Food 
{
    FRENCH_FRY(25.25f), SEASONED_CURLY_FRY(30.10f);

    private final float price;

    FRY(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }
}