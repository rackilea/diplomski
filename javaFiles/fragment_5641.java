class QuickSort{
  public static final int max = 10;

  public static void main(String[] args) {
    int[] toSortArray = new int[max];

    for (int i = 0; i < max; i++) {
      toSortArray[i] = (int) (Math.random() * 100);
    }

    System.out.println("The array to be sorted is:");

    for (int i = 0; i < max; i++) {
      System.out.print(" | " + toSortArray[i]);
    }
    System.out.println(" | ");

    // Beginning of the algorithm
    quicksortHelper(toSortArray, 0, max - 1);
    // End of the algorithm

    System.out.println("The sorted array is: ");
    for (int i = 0; i < max; i++) {
      System.out.print(" | " + toSortArray[i]);
    }
    System.out.println(" | ");
  }

  private static void quicksortHelper(int[] toSortArray, int first, int last) {
    if (first < last) {
      int splitpoint = partition(toSortArray, first, last);
      quicksortHelper(toSortArray, first, splitpoint - 1);
      quicksortHelper(toSortArray, splitpoint + 1, last);
    }
  }

  private static int partition(int[] array, int first, int last) {
    int temp;
    // Always assumes pivot index is first
    int pivot = array[first];

    // Swap Pivot and Last
    array[first] = array[last];
    array[last] = pivot;

    int mark = first;

    for(int i=first;i<last;i++){
      if(array[i] <= pivot){
        temp = array[mark];
        array[mark] = array[i];
        array[i] = temp;
        mark++;
      }
    }

    temp = array[last];
    array[mark] = array[last];
    array[last] = temp;

    return mark;
  }
}