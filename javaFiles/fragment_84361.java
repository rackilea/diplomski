public static void bubbleSort(String[] array) {
    boolean swapped = true;
    int compNumber = 0;
    int length = length.array;
    while (swapped == true) { //note the ==
      swapped = false;
      for (int i = 1; i < array.length; i++) {
        compNumber++;
        if (Integer.parseInt(array[i-1]) > Integer.parseInt(array[i])) {
          String temp = array[i-1]
          array[i-1] = array[i];
          array[i] = temp;
          swapped = true;
        }
      }
    }
    return compNumber; 
  }