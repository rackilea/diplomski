public static int partition(int[] array, int left, int right) {

  if(array.length == 1)
      return right;

  int pivot = array[0];
  int pivotIndex = 0;
  int leftPointer = left; // Remove the +1
  int rightPointer = right; // Remove the +1

  while(pivotIndex < right) {
      if(leftPointer > rightPointer) {
          break;
      }
    //leftPointer++;

      while((leftPointer < array.length - 1) && (array[leftPointer] <= pivot)) {
          leftPointer++;
      }
      //rightPointer--;

      while((rightPointer > leftPointer) && (array[rightPointer] > pivot)) {
          rightPointer--;
      }

      if(leftPointer < rightPointer) {
          int temp = array[leftPointer];
          array[leftPointer] = array[rightPointer];
          array[rightPointer] = temp;
      }
      else {
          int temp = array[rightPointer];
          array[rightPointer] = array[pivotIndex];
          array[pivotIndex] = temp;
      }
  }
  return rightPointer;