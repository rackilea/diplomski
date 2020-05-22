public static void main(String... args) throws Exception {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < 16; i++) {
        list.add(i);
    }
    System.out.println(list); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
    Collections.shuffle(list);
    System.out.println(list); //[11, 5, 10, 9, 7, 0, 6, 1, 3, 14, 2, 4, 15, 13, 12, 8]

    int[][] a2 = new int[4][4];
    for (int i = 0; i < 4; i++) {
        for (int j = 0;  j< 4; j++) {
            a2[i][j] = list.get(i*4 + j);
        }
    }
    System.out.println(Arrays.deepToString(a2)); //[[11, 5, 10, 9], [7, 0, 6, 1], [3, 14, 2, 4], [15, 13, 12, 8]]
}