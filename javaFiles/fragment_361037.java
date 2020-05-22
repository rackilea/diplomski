private static void sortInPlace(int[] arr, int left, int right) {

// OptQSort1:
int size = right - left + 1;
**if (size < 10 && !insertionSortCalled){**
      **insertionSortCalled=true;**
      **insertionSort(arr, 0, arr.length-1);**
  }

if (left >= right)
    return; // sorted

final int range = right - left + 1;
int pivot = random.nextInt(range) + left;

int newPivot = partition(arr, left, right, pivot);

sortInPlace(arr, left, newPivot - 1);
sortInPlace(arr, newPivot + 1, right);