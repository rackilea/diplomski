public enum Meal implements Food {
    HAPPY_MEAL(Fry.FRENCH_FRY, Fry.SEASONED_CURLY_FRY),
    SAD_MEAL(Salad.AFGHAN_SALAD);

    private final List<Food> items;

    Meal (Food... items) {
        this.items = Arrays.asList(food);
    }

    @Override
    public float getPrice()
    {
        return (float) items.stream().mapToDouble(Food::getPrice).sum();
    }
}