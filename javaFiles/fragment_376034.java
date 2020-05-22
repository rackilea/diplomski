for (int k = 0; k < column; k++) {

        int sum = 0;
        for (int j = 0; j < rows; j++) {
            sum += arrayTwo[j][k] * arrayOne[j];
        }

        productArray[k] = sum;

    }