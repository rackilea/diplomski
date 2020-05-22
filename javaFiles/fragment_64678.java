public class Journal5b {

   private int[] rowSpotted;//variable to keep rows of searched number
   private int[][] arrayToBeSearched; 

   public class Journal5b (int rows, int columns) {

       rowSpotted = new int[rows];
       arrayToBeSearched = new int[rows][columns];
       this.createArray();
       this.print2dArray();
   }

   private void createArray() {
      Random r = new Random();
      for (int[] array1 : arrayToBeSearched) {
         for (int number: array1) {
               number = r.nextInt(26);
         }
      }
   }

   //I removed the array local variable array so that you won't have to keep passing it as an argument, It's now an instance variable.
   //You can also use a for each loop to populate the inner array, no need to use the for loop.

  public void print2DArray () {
     for (int[] array1 : arrayToBeSearched) {
         for (int num: array1) {
           System.out.print(num + "\t");
         }
      System.out.println("\n");
     }
  }

  //just prints the array to be searched.

  public int countInstance (int searchForNum) {
      int count = 0;

      for (int row = 0; row < arrayToBeSearched.length; row++) {
          for (int column = 0; column < arrayToBeSearched[0].length; column++) {
               if (arrayToBeSearched[row][column] == searchForNum) {
                  rowSpotted[count] = row;  //if the number is found put the row number into the row
                  count++;
               }
          }
      }
      return count; 
  }

 public void printRowSpotted() {
     for(int num : rowSpotted ) {

        System.out.print(num + ',');
     }
 }

 public static void main(String[] args) {
    //scanner stuff......
    Journal5b jb = new Journal5b(10,10);
    //get number to be searched for....
   System.out.print("Your number popped up " + jb.countInstance() + ", on rows " + jb.printRowSpotted());

}