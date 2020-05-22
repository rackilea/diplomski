public class SortingArray
{
   public static void main(String[] args)
   {
      int[] array1 = { 5, 4, 3, 2, 1};
      bubbleSort(array1);
   }

   public static void bubbleSort(int[] array2)
   {      
      // Display the array's contents.
      System.out.println("Original order: ");
      for (int element : array2)
         System.out.print(element + " ");

      //int lastPos;     // Position of last element to compare
      int index;       // Index of an element to compare
      int temp;        // Used to swap to elements
      int count = 0;
      int count2 = 0;
      boolean swapped = true;


      while (swapped == true)
      {
         swapped = false;
         // The inner loop steps through the array, comparing
         // each element with its neighbor. All of the elements
         // from index 0 thrugh lastPos are involved in the
         // comparison. If two elements are out of order, they
         // are swapped.
         for (index = 0; index < array2.length - 1; index++)
         {
            count2++;
            // Compare an element with its neighbor.
            if (array2[index] > array2[index + 1])
            {
               count++;
               // Swap the two elements.
               temp = array2[index];
               array2[index] = array2[index + 1];
               array2[index + 1] = temp;
               swapped = true;
            }

         }
      }
      //count2++;

      // Display the array's contents.
      System.out.println("\nSorted order: ");
      for (int element : array2)
         System.out.print(element + " ");

      System.out.print("\n Swaps:" + count);
      System.out.print("\n Comparisons:" + count2);


   }

}