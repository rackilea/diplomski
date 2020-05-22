public int getMin(int d1, int d2, int d3) {
  int min = d1;
  if (d2 < min) {
    min = d2;
  }
  if (d3 < min) {
    min = d3;
  }
  return min;
}