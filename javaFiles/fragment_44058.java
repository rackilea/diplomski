public class VendingController() {

    private int drinksStocked = 0;
    private int drinksDispensed = 0;

    public void dispenseDrink() {
        drinksDispensed++;
    }

    public void stockDrinks(int numberOfDrinks) {
        drinksStocked = getDrinksRemaining() + numberOfDrinks;
        drinksDispensed = 0;
    }

    public int getDrinksRemaining() {
        return drinksStocked - drinksDispensed;
    }
}