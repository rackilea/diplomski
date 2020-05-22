public class MClab22{

      public static void main(String[] args)
      {
        int[] houseNums = {23, 76, 15, 47, 14, 38, 52};
        System.out.print("The original sequence is: \n     ");
        for (int i = 0;i < houseNums.length; i++)
        {
          System.out.print(houseNums [i] + ", ");
        }
        System.out.println();
        SortEm(houseNums);
      }
      private static void SortEm (int [] ar)
      {
        int temp;
        for (int i = ar.length - 1; i > 0; i--)
        {
          for (int j = 0; j < i; j++)
          {
            if (ar[j] > ar[j + 1])
            {
              temp = ar[j];
              ar[j] = ar[j + 1];
              ar[j+1] = temp;
            }
          }
        }

        System.out.print("The new sequence is : \n   ");
        for (int i=0; i < ar.length; i++)
        {
          System.out.print (ar[i] + ", ");
        }
        System.out.println();
      }

}