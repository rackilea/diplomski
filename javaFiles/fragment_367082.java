int p = nearCaptures.get(0).length;  // p is the common array length
// search for majorUpset
for(int j = 0; j < p; j++){
  for (double[] arr : nearCaptures) {
    if (arr[j]==majorUpset) return j; // first majorUpset
  }
}
// search for threshold
for(int j = 1; j < p; j++){
  for (double[] arr : nearCaptures) {
    if (arr[j]>arr[j-1]+threshold) return j-1; // first threshold
  }
}