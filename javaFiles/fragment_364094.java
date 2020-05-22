public class MatrixSort {

    private static final int MATRIX[][] = { 
              { 6, 8, 9, 16 }, 
              { 0, 6, -3, 4 }, 
              { 18, 2, 1, 11 } 
     };

    private static int[][] transpose(int[][] m) {
        int[][] ret = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                ret[j][i] = m[i][j];
        return ret;
    }

    public static void main(String[] args) {
        int ret[][] = transpose(MATRIX);
        for(int i=0; i < ret.length; i++) {
            Arrays.sort(ret[i]);
        }
        ret = transpose(ret);
        for(int i=0; i < ret.length; i++) {
            for(int j=0; j < ret[i].length; j++) {
                System.out.print(ret[i][j]);
                System.out.print(" | ");
            }
            System.out.print('\n');
        }
    }

}