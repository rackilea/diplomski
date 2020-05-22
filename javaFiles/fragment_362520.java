public static int progress(int[] a, int low, int high,int n){
        if (low==high)
            return a[low];
        //partition array and return index of pivot
        int j= partition(a, low, high, n);

        //find the kth position of the pivot 
        int k=j-low+1;
        //if the kth position of the pivot is the same as the required ith smallest int return pivot.
        if (k==n){
            return a[j];
        }
        else
        if (n<k)
           return progress(a, low, j-1, n, i);
        else if (n>k)
            return progress(a, j+1, high, n-k, i);
    }