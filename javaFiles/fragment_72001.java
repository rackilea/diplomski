int columnNumber = -1;    

for (int column = 0; column < available.length; column++) {

    boolean columnYes = true;        

    for (int row = 0; row < available.length; row++) {
        if (!available[row][column].equals("yes")) {
            columnYes = false;
        }
    }

    if (columnYes) {
        columnNumber = column;
        break;
    }
}