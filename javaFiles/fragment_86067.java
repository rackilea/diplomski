public static int[] getBinArray(int number) {
    int length = 0;
    while (number != 0) {
        number >>>= 1;
        length++;
    }
    return new int[length];
}

public static int[] decToBin(int number) {
    int[] array = getBinArray(number);
    int k = array.length-1;
    while (number != 0)
    {
        array[k--] = number & 1;
        number >>>= 1;
    }
    return array;
}