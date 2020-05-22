for (int row = 0; row < arr.length; row++) {
        for (int column = 0; column < arr.length - 1; column++) {
            double min = arr[row][column];
            int index = column;
            for (int j = column + 1; j < arr.length; j++) {
                if (min > arr[row][j]) {
                    min = arr[row][j];
                    index = j;
                }
            }
            if (index != column) {
                arr[row][index] = arr[row][column];
                arr[row][column] = min;
            }
        }
    }