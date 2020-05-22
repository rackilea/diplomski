public int[] sortNonEmptyArray(int[] input) {
    if (input.length == 0) {
         throw new IllegalArgumentException("empty array passed");
    }
    return sort(input);
}