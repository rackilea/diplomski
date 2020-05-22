private static int[] combine(int[]... arrays) {

    int maxArrayLen = Arrays.stream(arrays).mapToInt(array -> array.length).max().getAsInt();

    List<Integer> list = new ArrayList<Integer>();
    for (int j = 0; j < maxArrayLen; j++) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > j) {
                list.add(arrays[i][j]);
            }
        }
    }
    return list.stream().mapToInt(i -> i).toArray();
}