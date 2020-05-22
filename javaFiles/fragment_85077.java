public static void formatArray(double[][] array) {
        for(int i = 0; i < array.length; i++){
            for(int y = 0; y < array[0].length; y++){
                array[i][y] = (double)Math.round(array[i][y] * 10000) / 10000;
            }
        }

    }