int n = A.length;

for (int c = n - 1; c >= 0; c--) {
   // bubble sort
   for (int i = 0; i < n; i++) {
      for (int j = i; j < n ;j++) {
         if (A[i][c] < A[j][c]) {
            SWAP(A[i], A[j]); // swap the whole row
         }
      }
   }
}