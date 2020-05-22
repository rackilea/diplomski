public static void lowerNums(int average, int[] arr) {
    //For each int in the array
    for(int num : arr) {
       //If the int is less than the average, print it out
       if(num < average) {
          System.out.println(num);
       }
    }
}