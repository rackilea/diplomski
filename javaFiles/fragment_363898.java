public static void main(String[] args) {
    List<int[][]> list = new ArrayList<>();
    list.add(new int[][]{{1,2}, {3,4}});
    int[][] twoD = list.get(0);
    System.out.println(Arrays.deepToString(twoD));
}