public int[][] cartesianProduct(int[] s1, int[] s2) { 
    List<int[]> list = new ArrayList<>();
    for (int v1: s1) {
        for (int v2: s2) {
            list.add(new int[]{v1, v2});
        }
    }
    int[][] result = new int[list.size()][2];
    int k=0;
    for(int[] i: list){
        result[k++] = i;
    }   
    return result;
}