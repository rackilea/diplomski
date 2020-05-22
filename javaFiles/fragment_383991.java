public static int Total_2DArray_Elements_by_Certain_Row_Number(int[][] myArray)
   {// begin method to sum array by user input row
   java.util.Scanner input = new Scanner(System.in);
   int total = 0;
   System.out.println("\nPlease enter the row you would like to sum: ");
     int row = input.nextInt() - 1;
           for (int j = 0; j < myArray[0].length; j++) {
              total += myArray[row][j];
           }
       return total;   
   }// end..