public class BinaryConv {

public static void main(String[] args) throws Exception {
    int[][] p = {{1, 2}, {3, 4}};
    int[][] P = new int[2][14];
    int[][] P1 = new int[2][7];
    int[][] P2 = new int[2][7];
    int[] L1 = new int[28];
    for (int r = 0; r < 2; ++r) 
    {
        for (int c = 0; c < 14; ++c) 
        {
            P[r][c] = (p[r][c / 7] >> (7 - c % 7 - 1)) & 1;
            System.out.print(" " + P[r][c]);
        }
        System.out.println();
    }

    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
            P1[i][j] = P[i][j];
        }
    }

    for (int i = 0; i < 2; i++) 
    {
        for (int j = 7; j < 14; j++) 
        {
            P2[i][j - 7] = P[i][j];
        }
    }
    System.out.println("The sub matrix 'P1' is");
    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
            System.out.print(" "+P1[i][j]);
        }
        System.out.println();
    }
    System.out.println("The sub matrix 'P2' is");
    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
            System.out.print(" "+P2[i][j]);
        }
        System.out.println();
    }
    int l=0;
    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
                L1[l] = P1[i][j];
                L1[l+1] = P2[i][j]; 
                l+=2;
        }
    }
    int k =0;
    for (int i = 0; i < 2; i++) 
    {
        for(int j=0;j<7;j++)
        {
            P1[i][j] = L1[k];
            P2[i][j] = L1[k+14];
            k++;
    }

}
    System.out.println("The interlaced binary matrix 'P1' is");
    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
            System.out.print(" "+P1[i][j]);
        }
        System.out.println();
    }
    System.out.println("The interlaced binary matrix 'P2' is");
    for (int i = 0; i < 2; i++) 
    {
        for (int j = 0; j < 7; j++) 
        {
            System.out.print(" "+P2[i][j]);
        }
        System.out.println();
    }
}