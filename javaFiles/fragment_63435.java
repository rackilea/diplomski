int n = length(Symbols);
int k = length(A);
// TRACK WHICH LETTERS ARE STILL AVAILABLE
available = sort(Symbols minus A);
// SEARCH BACKWARDS FOR AN ENTRY THAT CAN BE INCREASED
for (int i=k-1; i>=0; --i) {
    // LOOK FOR NEXT SMALLEST AVAILABLE LETTER
    for (int j=0; j<n-k; ++j) {
        if (A[i] < available[j]) {
            break;
        }
    }
    if (j < n-k) {
        // CHANGE A[i] TO THAT, REMOVE IT FROM AVAILABLE
        int tmp = A[i];
        A[i] = available[j];
        available[j] = tmp;
        // RESET SUBSEQUENT ENTRIES TO SMALLEST AVAILABLE
        for (j=i+1; i<k; ++j) {
            A[j] = available[i+1-j];
        }
        return A;
     } else {
         // A[i] MUST BE LARGER THAN AVAILABLE, SO APPEND TO END
         available = append(available,A[i]);
     }
}