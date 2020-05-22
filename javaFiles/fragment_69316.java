public class MagicSquare {

    private static int[][] magicSquare;
    private static int size; 

    public static void main(String[] args) {

        size = readValueFromFile();

        boolean validNum = false;

            if (size<3) {
                System.err.println("Enter a positive integer square size of 3 or more");
                validNum = false;
            } else {
                validNum = true;
            }

        if(validNum){
            magicSquare = new int [size][size];
            MagicSq(magicSquare,size);
            displaySquare();

        }
    }

    /**
     * The following function determines which magic square operation to perform given the order(n)
     * @param magicSquare
     * @param size
     */
    public static void MagicSq(int[][] magicSquare,int size) {
        if(size%2==1)
            OddMagicSquare(magicSquare,size);
        else if (size%4==0)
            DoubleEvenMagicSquare(magicSquare,size);
        else
            SinglyEvenMagicSquare(magicSquare,size);

    }

    public static void SinglyEvenMagicSquare(int[][] magicSquare,int size) {
      int i, j, k, index=0;

      int p=size/2;

      int [][] M =  new int [p][p];

      MagicSq(M,p);

      System.out.println();

      for (i=0; i<p; i++)
        for (j=0; j<p; j++) {
          magicSquare[i][j]=M[i][j];
          magicSquare[i+p][j]=M[i][j]+3*p*p;
          magicSquare[i][j+p]=M[i][j]+2*p*p;
          magicSquare[i+p][j+p]=M[i][j]+p*p;
        }

      if (size==2)
        return;  

      int [] I = new int[p];
      int [] J = new int[size];

      for (i=0; i<p; i++)
        I[i]=i+1;

      k=(size-2)/4;

      for (i=1; i<=k; i++)
        J[index++] = i;

      for (i=size-k+2; i<=size; i++)
        J[index++] = i;

      int temp;
      for (i=1; i<=p; i++)
        for (j=1; j<=index; j++){
          temp=magicSquare[i-1][J[j-1]-1];
          magicSquare[i-1][J[j-1]-1]=magicSquare[i+p-1][J[j-1]-1];
          magicSquare[i+p-1][J[j-1]-1]=temp;
        }

      i=k; 
      j=0;
      temp=magicSquare[i][j]; 
      magicSquare[i][j]=magicSquare[i+p][j]; 
      magicSquare[i+p][j]=temp;

      j=i;
      temp=magicSquare[i+p][j]; 
      magicSquare[i+p][j]=magicSquare[i][j]; 
      magicSquare[i][j]=temp;
    }

   //truncated for clarity
}