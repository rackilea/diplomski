private static int[] find(char[][] image, char[][] waldo) {
    int row = -1;
    int column = -1;
    char first_waldo = waldo[0][0]; // first char of waldo
    boolean continue1 = true; // this is used to avoid looping when the indexes tried are not a possible answer
    int size = waldo.length * waldo[0].length; // number of elements of waldo
    int cont = 0;

    for (int i = 0; i < image.length; i++) {
        for (int j = 0; j < image[i].length; j++) { // Looping over chars in image array
            char current = image[i][j]; // Current char of image array
            if (current == first_waldo) { // If true, this indexes (i, j) are a possible answer
                row = i; // Current image row
                column = j; // Current image column
                cont = 0; // Count of how many chars are matched
                for (int k = row; k < row + waldo.length; k++) {
                    for (int l = column; l < column + waldo[0].length; l++) { // Looping over
                                                       // the possible matching array in image
//                          System.out.println("Comparing " + image[k][l] + " with " + waldo[k - row][l - column]);
//                          System.out.println(k + " " + l);
                        if (waldo[k - row][l - column] == '.') { // If its a point, count as matching characters
                            cont++;
                            continue; 
                        }
                        if (image[k][l] != waldo[k - row][l - column]) { // If chars are different, it's not the answer
                            row = -1;
                            column = -1;
                            continue1 = false; // So it doesn't continue looping
                            break;
                        } else {
                            cont++; // If they are equals, count as matching characters
                        }
                    }
                    if (continue1 == false) { // To avoid overlooping when it's not the answer
                        continue1 = true; // Reset value
                        break;
                    }
                }
                if (cont == size) { // Is the number of matched charactes equal to the size of waldo?
                    int[] res = {row, column};
                    return res; // Return indexes
                }

            } else {
                row = -1;
                column = -1;
            }

        }
    }
    int[] res = {-1, -1};
    //      System.out.println("\n" + row +" , " +  column);
    return res; // Not answer

}