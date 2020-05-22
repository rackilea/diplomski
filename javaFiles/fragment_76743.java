public class PrintArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] table = new int[4][4];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                // System.out.println("Enter a number.");
                int x = input.nextInt();
                table[i][j] = x;
            }
            //System.out.println();
        }
        // System.out.println(table);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}