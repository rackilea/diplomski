public static void main(String[] args) {
    int[][] grid = new int[][] { 
        { 12, 64, 35 },
        { 95, 89, 95 },
        { 32, 54,  9 },
        { 87, 56, 12 }};
    Arrays.sort(grid, new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });
    System.out.println(Arrays.deepToString(grid).replace("],", "],\n"));
}