public static void MergeSort(Employee[] A)
 {
   int n = A.length;
   int i, j,mid;
   if(n < 2)
      return;

   mid = n / 2;
   Employee[] left = new Employee[mid];
   Employee[] right = new Employee[n - mid];

   for(i = 0; i < mid; i++)
      left[i] = A[i];
   for(i = 0; i< n-mid; i++)
      right[i] = A[i+mid];
   MergeSort(left);
   MergeSort(right);
   Merge(left, right, A);
 }