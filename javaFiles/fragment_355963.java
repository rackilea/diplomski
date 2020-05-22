private static int dC(int[] a, int f, int l) {
        if(l == f)
            return f;
        int m = (f+l) / 2;
        int left = dC(a, f, m);
        int right = dC(a, m+1, l);
        if(a[left] > a[right])
            return left;
        else
            return right;
    }