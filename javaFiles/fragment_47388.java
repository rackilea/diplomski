public final class DrinkEnumExample {

    public interface DrinkTypeInterface {

        String getDisplayableType();
    }

    public static enum DrinkType implements DrinkTypeInterface {

        COFFEE("Coffee"), TEA("Tea");
        private final String type;

        private DrinkType(final String type) {
            this.type = type;
        }

        public String getDisplayableType() {
            return type;
        }
    }

    public static enum Drink implements DrinkTypeInterface {

        COLUMBIAN("Columbian Blend", DrinkType.COFFEE),
        ETHIOPIAN("Ethiopian Blend", DrinkType.COFFEE),
        MINT_TEA("Mint", DrinkType.TEA),
        HERBAL_TEA("Herbal", DrinkType.TEA),
        EARL_GREY("Earl Grey", DrinkType.TEA);
        private final String label;
        private final DrinkType type;

        private Drink(String label, DrinkType type) {
            this.label = label;
            this.type = type;
        }

        public String getDisplayableType() {
            return type.getDisplayableType();
        }

        public String getLabel() {
            return label;
        }
    }

    public DrinkEnumExample() {
        super();
    }

    public static void main(String[] args) {
        System.out.println("All drink types");
        for (DrinkType type : DrinkType.values()) {
            displayType(type);
            System.out.println();
        }
        System.out.println("All drinks");
        for (Drink drink : Drink.values()) {
            displayDrink(drink);
            System.out.println();
        }
    }

    private static void displayDrink(Drink drink) {
        displayType(drink);
        System.out.print(" - ");
        System.out.print(drink.getLabel());
    }

    private static void displayType(DrinkTypeInterface displayable) {
        System.out.print(displayable.getDisplayableType());
    }
}