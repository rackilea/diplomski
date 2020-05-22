public class Hunger {

    public static void main(String[] args) {
        for (Food food : Food.values()) {
            System.out.printf("%d   %-8s %d\n", food.ordinal(), food.caption, food.sustenance);
        }
        System.out.print("Hungry? Make your choice: ");
        Scanner scanner = new Scanner(System.in);
        Food food;
        while (true) {
            try {
                food = Food.values()[scanner.nextInt() - 1];
                break;
            } catch (Exception e) {
                System.out.println("Naa ... choose again: ");
            }
        }
        System.out.printf("This %s was yummy!\n", food.caption);
    }
}

enum Food {

    HOT_DOG("Hot Dog", 3),

    CUP_CAKE("Cup Cake", 2);

    final String caption;
    final int sustenance;

    private Food(String caption, int sustenance) {
        this.caption = caption;
        this.sustenance = sustenance;
    }
}