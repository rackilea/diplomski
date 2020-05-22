public static boolean isArrayInSortedOrder (int[] array, int index) {
    if (array.length == 1 || index == 1) { //base case
        return true;
    }

    int a1 = array[index - 1];
    int a2 = array[index - 2];
    if (a1 > a2) {
        return isArrayInSortedOrder(array, index - 1);
    }   

    return false;
}