// No need to pass `pivot` as parameter. Just use `high`.
public static int DPartition(int [] A, int low, int high) {  
    int i=low;
    int j=high;
    boolean leftToRight = false;
    boolean rightToLeft = true;

    while (i <= j) {   // Iterate till middle

        if (leftToRight) {  // Move left to right

            while(i <= j && A[i] <= A[j]){
                i=i+1;  // Move right until condition is satisfied
            }
            if (i < j) {   // If `i` has not moved beyond `j`. Perform Swap
                swap(i, j, A);   // Pass index for swapping along with array.
            }
            leftToRight = false;   // Toggle to change direction.
            rightToLeft = true;

        } else if (rightToLeft) {  // Move right to left.

            while(j >= i && A[j] >= A[i]){
                j=j-1;
            }
            if (j > i) {    // If j has not moved beyond `i`. Perform Swap
                swap(i, j, A);
            }
            rightToLeft = false;   // Toggle to change the direction
            leftToRight = true;
        } 
    }
    return i;   // Return `index` to split.
}

public static void swap(int p, int q, int[] a) {
    System.out.println("p = " + p + ", q = " + q);
    int temp = a[p];
    a[p] = a[q];
    a[q] = temp;
}