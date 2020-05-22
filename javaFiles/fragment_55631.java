import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewMain1 {

 static int[][] m ;

 public static void rotate(int[][] matrix, int n) {

        for (int layer = 0; layer < n / 2; ++layer) {

            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; ++i) {

                int offset = i - first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i] = matrix[last-offset][first]; 
                printmove(last-offset,first,first,i);

                // bottom -> left
                printmove(last,last-offset,last-offset,first);
                matrix[last-offset][first] = matrix[last][last - offset]; 

                // right -> bottom
                printmove(i,last,last,last-offset);
                matrix[last][last - offset] = matrix[i][last]; 

                // top -> right
                printmove(first,i,i,last);
                matrix[i][last] = top; // right <- saved top
                System.out.println("");
                printmatrix(matrix,n);
                System.out.println("");
              try{
                int s = System.in.read();
              } catch (IOException ex){ }
            }
        }
    }

 static void printmove(int r1, int c1, int r2, int c2){
    System.out.println("["+(r1+1)+"]["+(c1+1)+ "] moves to [" + (r2+1) + "][" + (c2+1) + "]");
 }

 static void printmatrix(int[][] m, int n){
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(m[i][j] + " ");
       }
      System.out.println("");
   }
 }

  static void makematrix(int[][] m, int n){
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        m[i][j] = 10*(i+1) + j+1;
       }
    }
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] m = new int[n][n];
    makematrix(m, n);
    printmatrix(m, n);
    rotate(m,n);
    System.out.println("");
    printmatrix(m, n);
 }

}