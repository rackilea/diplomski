public static void reorder(int[][] a){
Arrays.sort(a, new Comparator<int[]>() {
    @Override
    public int compare(final int[] a, final int[] b) {
         Integer c = Integer.valueOf(a[0]);
         Integer d = Integer.valueOf(b[0]);
        return c.compareTo(d);
    }
    });
}