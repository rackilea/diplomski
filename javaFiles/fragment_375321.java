int lb(int a[], int last, int val) { // array, len of the array, element to insert
  int it, count, step;
  int first = 0;
  count = (last-first);
  while (count > 0) {
    it = first;
    step = count/2;
    it += step;
    if (a[it] < val) {
      first = ++it;
      count -= step+1;
    } else
      count = step;
  }
  return first;
}