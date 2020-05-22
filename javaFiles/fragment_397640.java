public boolean containsValue(int[][] data, int z) {
    for (int i = 0; i < data.length; i++) {
        if (Arrays.asList(data[i]).contains(z)) {
            return true;
        }
    }
    return false;
}