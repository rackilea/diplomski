private boolean isSorted(int[] arr, int start) {
  if (arr.length - start < 2) 
      return True;

  if (arr[start] > arr[start+1])
      return False;

  return isSorted(arr, start+1)

}