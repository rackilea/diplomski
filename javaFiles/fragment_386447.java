//get the size of the ResultSet
    myResultSet.last();
    int resultSetSize = myResultSet.getRow();
    //initialize your arrays to be joined
    int[] array1 = new int[resultSetSize];
    int[] array2 = new int[resultSetSize];
   //loop through the result so array1 will be the same as column1 of your table, etc.
    int count = 0;
    myResultSet.beforeFirst();
    while (myResultSet.next()){
        array1[count] = myResultSet.getInt("my column 1");
        array2[count] = myResultSet.getInt("my column 2");
        count++;
    }
    //declare rows and columns for easy code readability
    int row = 0;
    int column = 2;
    //set your combined array row and column lengths
    int[][] aCombined = new int[array1.length][column];
    //reset your column value to put array1 down column 0
    column = 0;
    for (int tempInt : array1){
        aCombined[row][column] = tempInt;
        row++;
    }
    //reset your row and go to the next column to do the same as above
    row = 0;
    column = 1;
    for (int tempInt : array2){
        aCombined[row][column] = tempInt;
        row++;
    }