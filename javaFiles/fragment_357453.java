public static String[] increaseSize(String[] array, int newLength) {
    if (array.length >= newLength)
        return array;
    String[] newArray = new String[newLength];
    for (int i = 0; i < array.length; i++)
        newArray[i] = array[i];
    return newArray;
}