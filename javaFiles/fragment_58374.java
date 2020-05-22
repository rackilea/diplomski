public static void main(String[] args) {
  Scanner in = new Scanner(System.in);

  int[] numbers = new int[20];

  // boolean mustKeepSerie = true;
  int sum = 0, input = 0, counter = 0;

  System.out.print("Series ");

  boolean isAcceptableSerie = false;

  boolean isCurrentSerieValid = true;

  while (!isAcceptableSerie) {

    input = in.nextInt();

    // condition exit or loop again if input <0
    if (input < 0) {

      if (isCurrentSerieValid) {
         isAcceptableSerie = true;
       }

       else {
         printDiscardedSerie(numbers,counter);
         sum = 0;
         counter = 0;
         isCurrentSerieValid=true;
       }
       continue;
    }

    numbers[counter] = input;
    sum += numbers[counter];

    if (sum > 50 || numbers[counter] > 15) {
      isCurrentSerieValid = false;
    }

    // condition exit or loop again if counter==19
    if (counter == 19) {
      if (isCurrentSerieValid) {
          isAcceptableSerie = true;
      }
      else {
          printDiscardedSerie(numbers,counter);
          sum = 0;
          counter = 0;
          isCurrentSerieValid=true;
      }
      continue;
    }
    counter++;
  }
}


private static void printDiscardedSerie(int[] numbers, int counter) {
  System.out.print("Series ");
  for (int i=0; i<counter;i++){
    if (i>=1){
      System.out.print(" ");
    }
    System.out.print(numbers[i]);
  }
}