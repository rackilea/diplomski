public class Main {
    public static void main(String[] args) {
        int n = 5;
        int i;
        int j;
        int k;
        // Using a triple nested loop to generate i, j, k position vectors

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    furtherProcessing(i, j, k);
                }
            }
        }
    }

    public static void furtherProcessing(int i, int j, int k) {
        System.out.println("Particle has position vectors " + i + "i " + j + "j " + k + "k");
    }
}