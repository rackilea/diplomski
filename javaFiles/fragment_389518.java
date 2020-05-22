import java.util.Random;

public class ArrayGrid
{
   public static void main(String[] args)
   {  
      int[][] ranAr = new int[10][10];

      // Complete 20 times
      for(int i = 0; i < 20; i++)
      {
         // Get random value between 0-9
         // for the array position
         Random r = new Random();
         int posOne = r.nextInt(10);
         int posTwo = r.nextInt(10);

         // Ensure the position has not already been set
         while(ranAr[posOne][posTwo] == -1)
         {
            posOne = r.nextInt(10);
            posTwo = r.nextInt(10);   
         }

         // Set value to position
         ranAr[posOne][posTwo] = -1;
      }

      // Print the grid to verify
      for(int x = 0; x < 10; x++)
      {
         for(int j = 0; j < 10; j++)
         {
            System.out.printf("%5d ", ranAr[x][j]);
         }
         System.out.println();
      }
   }
}