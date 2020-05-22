if (columnsFilled == 10) {
    for(int col = 1; col < grid.getNumCols() - 1; col++){
        grid.get(new Location( row,col )).removeSelfFromGrid();
    }
    columnsFilled = 0;
}