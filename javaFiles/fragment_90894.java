public int sum(int[] array) {
    return sum(array, 0, 0); 
}

private int sum(int[] array, int idx, int acc) {
    if (idx == array.length)
        return acc;
    return sum(array, idx+1, acc+array[idx]);
}