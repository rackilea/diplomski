public class Array {

    public static void main(String args[]) {
        double alpha[] = new double[50];

        // Initialize the first 25 elements of the array (int i=0; i<25; i++)
        for (int i = 0; i < 25; i++) {
            alpha[i] = i * i;
        }

        // Initialize the last 25 elements of the array (i=25; i<50; i++)
        for (int i = 25; i < 50; i++) {
            alpha[i] = 3 * i;
        }

        System.out.println("The values are: ");

        // Print the element of the array
        print(alpha);

    }

    // Print method to display the element of the array
    private static void print(double m_array[]) {
        for (int i = 1; i <= m_array.length; i++) {
            System.out.print(m_array[i-1] + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}