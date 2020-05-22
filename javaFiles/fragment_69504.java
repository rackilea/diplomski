import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows");
        int row = sc.nextInt();
        int[][] twod = new int[row][];
        for (int i = 0; i < row; i++) {

            int p = i + 1;
            System.out.println("Enter number of columns for row number " + p);

            int column = sc.nextInt();//for simplicity

            twod[i] = new int[column];

            for (int k = 0; k < column; k++) {
                int wat = k + 1;
                System.out.println("Enter element in row number " + p + " and column number " + wat);
                twod[i][k] = sc.nextInt();
            }
        }

        for (int men = 0; men < twod.length; men++) {
            for (int women = 0; women < twod[men].length; women++) {
                System.out.print(twod[men][women]);
            }
        }
    }
}