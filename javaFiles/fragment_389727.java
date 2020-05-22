public class RectangleWithShapesExample {
    public static void main(String[] args) {
        int number = 9;

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i == 0 || i == number - 1) {
                    System.out.print("+");
                } else {
                    if (j == 0 || j == number - 1) {
                        System.out.print("+");
                    } else if (i == j || i == (number - j - 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("");
        }
    }
}