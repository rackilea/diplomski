boolean isFull(int[][] arr) {
    for (int[] line : arr) {
        for (int elem : line) {
            if (elem == 0) {
                return false;
            }
        }
    }
    return true;
}