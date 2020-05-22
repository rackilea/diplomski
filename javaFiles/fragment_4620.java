public class Sample {

    public static void main(String[] args) {

        for (int g = 1; g <= 100; g++) {
            if ((g % 2) == 0 && (g % 3) == 0) {
                System.out.println(g + " is divisible by 2 and 3");
            } else {
                System.out.println(g + " is not divisible by 2 and 3");
            }

            if ((g % 7) == 0 || (g % 9) == 0) {
                System.out.println(g + " is divisible by 7 or 9");
            } else {
                System.out.println(g + " is not divisible by 7 or 9");
            }

            if (((g % 2) == 0) && ((g % 3) == 0)) {
                if ((g % 5) == 0) {
                    System.out.println(g + " is divisible by 2 and 3 and 5");
                } else {
                    System.out.println(g + " is divisible by 2 and 3 but 5");
                }
            } else if ((g % 5) == 0) {
                System.out.println(g + " is not divisible by 2 and 3 but 5");
            } else {
                System.out.println(g + " is not divisible by 2 and 3 and 5");
            }
        }
    }
}