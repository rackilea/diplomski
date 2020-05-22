// assume that the matrix has at least one row and thas the same number of columns in each row
    // take the number of columns in the first row for reference
    int numberOfColumns = matrix[0].length;
    for(int col = 0; col < numberOfColumns; col++) {
        int count = 0;
        // iterate over all the rows
        for(String[] row : matrix) {
            // count the length of the element in position col of this row
            count += row[col].length();
        }
        System.out.printf("%s characters in column %s", count, col);
    }