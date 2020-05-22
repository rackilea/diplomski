int[] counterarray = new int[10];
for (x = 14; x >= 0; x--)
{
  if (anArray[x] >= 0 && anArray[x] < 101) {
    int idx = Math.min(anArray[x] / 10, 9);
    ++counterarray[idx];
  }
}