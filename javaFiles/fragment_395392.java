public static <T> T[][] copyOf(T[][] array, int newLength) {
    // ensure that newLength >= 0
    T[][] copy = new T[newLength][];
    for (int i = 0; i < copy.length && i < array.length; i++) {
        copy[i] = Arrays.copyOf(array[i], array[i].length);
        // this should also work, just not create new array instances:
        // copy[i] = array[i];
    }
    return copy;
}