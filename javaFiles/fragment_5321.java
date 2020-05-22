// Making a call to set the cell in the 1st row at the 4th column, to 0
setCell(0, 1, 4, playedValues);

public void setCell(int value, int row, int column, ArrayList<Integer[]> grid) {
    int[] rowArray = grid.get(row);
    rowArray[column] = value;
}