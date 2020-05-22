public static int bs2(int[] array, int left, int right, int elem) {
    System.out.println("["+left+", "+right+"]");
    if (left >= right)
        return left;

    int middle;
    middle = (left + right) / 2;
    if (elem > array[middle])
        return bs(array, middle + 1, right, elem);
    if ((elem < array[middle]))
        return bs(array, left, middle, elem); //<--- was: middle-1
    return middle; // element existed into array
}