public Jewel[] getRow(int row) { 
    Jewel[] result = new Jewel[myGrid.length];
    for (int i = 0; i < myGrid.length; i++) {
        result[i] = myGrid[i][row];
    }
    return result; 
}