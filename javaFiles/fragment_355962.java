private static int dC(int[] a, int f, int l) {
        if(l == f) // <-- This mean you have one item, so you want to return it.
            return f;
        if(a[dC(a, f, (int)(Math.floor((double)(f+l)/2)))] > a[dC(a, (int)(Math.floor((double)(f+l)/2)+1), l)])
            return dC(a, (int)(Math.floor((double)(f+l)/2)+1), l);
        else
            return dC(a, f, (int)(Math.floor((double)(f+l)/2)));
    }