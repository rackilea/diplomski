for (j=0; j < coins.length; j++) {
     c = coins[j];
     for (i=amount; i >= c; i--){
          if (A[i - c] > 0)
              A[i] = Min(A[i], A[i - c] + 1);
     }
 }
 result = A[amount] - 1;