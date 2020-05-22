private String[] selectionSort(String[] stringArray) {
    for (int j = 0; j < stringArray.length - 1; j++) {
        int min = j;
        for (int k = j + 1; k < stringArray.length; k++) {
            if (stringArray[k].compareTo(stringArray[min]) < 0) {
                min = k;
            }
        }
        swap(stringArray, j, min);
    }
    return stringArray;
}