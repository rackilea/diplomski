public void recQuicksort(int left, int right) {
  if (left < right) {
    long pivot = array[right];
    int partition = partitionIt(left, right, pivot);
    recQuicksort(left, partition - 1);
    recQuicksort(partition, right);
  }
}