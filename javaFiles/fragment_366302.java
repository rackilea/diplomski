public class Test {
    public static void main(String[] args) {
        int previousMove = 3; //Change this to test

        int startMethod = previousMove - 1 < 0 ? 3 : previousMove - 1; //Represents the ID of the method before the previousMove, accounting for negative values and wrapping around
        int offset = startMethod - 1 < 0 ? 3 : startMethod - 1; //Represents the ID of the method before the startMethod, accounting for negative values and wrapping around

        for (int i = startMethod; true; i++) {
            if (i > 3) i = 0; //Wrap around
            switch (i) {
                case 0: right(); break;
                case 1: up(); break;
                case 2: left(); break;
                case 3: down(); break;
            }
            if (i == offset) break; //Break once all 4 methods have been called
        }
    }

    private static void right() {
        System.out.println("Calling right");
    }

    private static void up() {
        System.out.println("Calling up");
    }

    private static void left() {
        System.out.println("Calling left");
    }

    private static void down() {
        System.out.println("Calling down");
    }
}