private final static float[][] matrix = {
    {2f, 8f, 5f},
    {9f, 7f, 4f},
    {8f, 5f, 6f},
    {7f, 3f, 9f},
    {1f, 5f, 5f},
    {8f, 7f, 5f},
};


@Test
public void minOfMatrixColumn() {
    Map<Integer, List<Float>> minsMap = new LinkedHashMap<>();
    for(int r = 0; r < matrix.length; r++) {
        float min = Float.MAX_VALUE;
        int mc = 0;
        for(int c = 0; c < matrix[r].length; c++) {
            if(matrix[r][c] < min) {
                min = matrix[r][c];
                mc = c;
            }
        }
        List<Float> minList = minsMap.get(mc);
        if(minList == null) {
            minList = new ArrayList<>();
            minsMap.put(mc, minList);
        }
        minList.add(min);
    }
    for(Entry<Integer, List<Float>> e : minsMap.entrySet()) {
        System.out.println("Min values in column " + e.getKey() + ": " + e.getValue());
    }
}