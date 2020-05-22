public static int Total_2DArray_Elements_by_Certain_Column_Number(int[][] myArray)
   {// begin method to sum array by user input column
   java.util.Scanner input = new Scanner(System.in);
   int total = 0;
   System.out.println("\nPlease enter the column you would like to sum: ");
     int column = input.nextInt() - 1;
     for (int i = 0; i < myArray.length; i++) {
           total += myArray[i][column];
        }
     return total;
   }// end m..