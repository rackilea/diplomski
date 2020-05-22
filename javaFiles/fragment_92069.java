public static int[] getEvens(int a[]) {
    int myEvens = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] % 2 == 0) {
         myEvens++;
      }    
    }

    //the code to actually add the evens to a new array
    int[] evenArray = new int[myEvens];
    int evenIndex = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] % 2 == 0) {
        evenArray[evenIndex] = a[i];
        evenIndex++;
      }    
    }
    Arrays.sort(evenArray);

    return evenArray;
}