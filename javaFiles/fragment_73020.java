Arrays.sort(data, new Comparator<int[]>() {
    public int compare(int[] a, int[] b)  {
        // compare years
        if (a[2] == b[2]) {
            // compare months
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                // compare days
                return Integer.compare(a[0], b[0]);
            }
        } else {
            return Integer.compare(a[2], b[2]);
        }
    }
});