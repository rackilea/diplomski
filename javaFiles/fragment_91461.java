public class MatrixDiagonal {

    public static void main(String[] args) {
        int m = 4, n = 5;
        int[][] matrix = {  { 0, 1, 2, 3, 4 }, 
                    { 5, 6, 7, 8, 9 },
                    { 10, 11, 12, 12, 14 }, 
                    { 15, 16, 17, 18, 19 } };
        for(int j=n-1; j>=0; j--){
            for(int k=0; k<m; k++){
                if((j + k) < n){
                    System.out.print(matrix[k][j + k] + " ");
                } else {
                    break;
                }
            }
            System.out.println();
        }
        for(int i=1; i<m; i++){
            for(int j=i, k=0; j<m && k<n; j++, k++){
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }
    }

}