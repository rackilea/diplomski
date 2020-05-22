private int sum1(int[] array, int index) {
    if (index == array.length) {
        return 0;
    }
    return array[index] + sum1(array, index + 1);
}

public int sum(int[] array) {
    return sum1(array, 0);
}