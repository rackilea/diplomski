private static boolean[][] PutValuesInArray(boolean array[][]) {

    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j+=2) {
            array[i][j] = true;

        }

    }

    for (int i = 0; i < array.length; i++) {
        for (int j = 1; j < array[i].length; j+=2) {
            array[i][j] = false;
        }
    }

    return array;
}