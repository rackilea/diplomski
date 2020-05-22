static void MoveOddElementToRightPosition(int[] a, int oddPosition)
 {
   int h = a[oddPosition];
   int i;
   if (h > a[oddPosition + 1])
     for (i = oddPosition; i < a.Count()-1 && a[i+1] <= h; i++)
        a[i] = a[i+1];
   else
     for (i = oddPosition; i > 0 && a[i-1] >= h; i--)
        a[i] = a[i - 1];
   a[i] = h;
 }