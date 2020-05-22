package sample;

import java.util.Stack;

public class A {

    void go(int[][] matrix) {

        Stack<Integer> takeCol = new Stack<>();

        int numPushTake=0;
        int numPushTemp=0;

        for (int i = 0; i < matrix.length; i++) {

            //take columns and make them rows (ROTATION METHOD)
            for (int j = matrix[i].length - 1; j >= 0; j--) {

                int val = matrix[j][i];
                System.out.printf("pushing num=[%d] val=%d%n", ++numPushTake, val);
                takeCol.push(val);
            }

            //reverse stack
            Stack<Integer> temp = new Stack();
            while (!takeCol.isEmpty()) {

                int val = takeCol.pop();
                System.out.printf("pushing temp num=[%d] val=%d%n", ++numPushTemp, val);
                temp.push(val);
            }

            //rotate matrix
            for (int j = 0; j < matrix[i].length; j++) {

                int val = temp.pop();
                System.out.printf("writing to m[%d,%d] val=%d%n", i, j, val);
                matrix[i][j] = val;
            }
        }
    }

    void dump(int[][] m) {
        for (int i=0;i<m.length;i++) {
            for (int j=0;j<m[i].length;j++)
                System.out.print(m[i][j]+" ");
            System.out.println("");
        }           
    }

    public static void main(String[] args) {
        A o = new A();
        int[][] matrix = {
                {3, 9, 8, 2 },
                {5, 5, 5, 1 },
                {4, 7, 6, 4 },
                {4, 1, 8, 2 }
        };
        o.dump(matrix);
        System.out.println("\n");
        o.go(matrix);
        o.dump(matrix);
    }
}