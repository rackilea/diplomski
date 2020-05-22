public class ArrayLoop {

    public static void main(String args[]) {
        double alpha[] = new double[50];

        for (int i = 0; i < 25; i++) {
            alpha[i] = i * i;
        }

        for (int i = 25; i < 50; i++) {
            alpha[i] = 3 * i;
        }

        System.out.println("The values are: ");
        for (int i = 0; i < 50; i++) {
            System.out.print(alpha[i] + " ");
        }

        System.out.println();
        System.out.println();

        for (int i = 1; i < alpha.length; i++) {
            if (i != 1 && i % 10 == 0) {
                System.out.print(alpha[i - 1] + " ");
                System.out.println();
            } else {
                System.out.print(alpha[i - 1] + " ");
            }

        }
        System.out.print(alpha[49]);
    }
}