double[] storage = new double[4];//You should calculate this value
    int k = 0;
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            storage[k++] = array[i][j];
        }
    }