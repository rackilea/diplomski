static int median(int a[], int i, int n)
   {
      Arrays.sort(a, i, i + n - 1);

      return a[i + n / 2];
   }