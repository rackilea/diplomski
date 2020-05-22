int max = arr.length;
for (int i = 0, int j = 0; j < max; j++) {
  if (arr[j] != 0) {
    if (i < j) {
      swap(arr, i, j);
    }
    i++
  }
}