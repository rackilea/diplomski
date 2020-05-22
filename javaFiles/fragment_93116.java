public static void main(String[] args) {
        String spacer = "                         ";
        for (int i = 1; i <= 128; i = i * 2) {

            // x is the number printed
            // it gets the value from i,
            System.out.print(spacer);
            for (int x2 = 1; x2 <= i - 1; x2 = x2 * 2) {
                System.out.print(" ");
                System.out.print(x2);
            }
            for (int x = i; x >= 1; x = x / 2) {
                System.out.print(" ");
                System.out.print(x);
            }
            if ((i * 2) < 10)
                spacer = spacer.substring(0, spacer.length() - 2);
            else if ((i * 2) < 100)
                spacer = spacer.substring(0, spacer.length() - 3);
            else
                spacer = spacer.substring(0, spacer.length() - 4);
            System.out.println();
        }
}