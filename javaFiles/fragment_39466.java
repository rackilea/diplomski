public static int bs(int[] array, int left, int right, int elem) {
    System.out.println("["+left+", "+right+"]");
    if (left > right) {
        return left;
    } else {
        int middle;
        middle = (left + right) / 2;
        if (left == right) { // used to return the insert position
            return left;
        } else if (elem > array[middle]) {
            return bs(array, middle + 1, right, elem);
        } else if ((elem < array[middle])) {
            return bs(array, left, middle, elem); //<-- was: middle-1
        } else {
            return middle; // element existed into array
        }
    }
}