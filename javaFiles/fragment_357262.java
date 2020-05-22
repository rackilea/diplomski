for (int row = 0; row < arr.length; row++) {

        for (int col = 0; col < arr[0].length; col++) {

            // once I reach the last pos I enter the count
            // of numbers greater than or equal to zero in that row/col
            if(arr[row][col]>=0){
              matrix[row][matrix[row].length-1] = matrix[row][matrix[row].length-1] + 1;

              matrix[matrix.length-1][col]= matrix[matrix.length-1][col] + 1;
            }


            matrix[row][col] = arr[row][col];

            }