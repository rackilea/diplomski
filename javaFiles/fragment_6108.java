int i = fiboCount - 1;
while (fiboSeries[i] >= n) {
  if (fiboSeries[i] == n) return true;
  i--;
}
return false;