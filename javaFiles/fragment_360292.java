public class Matrix {

    public Cell[][] populateCells(int xCols, int yRows) {
        Cell c[][] = new Cell[xCols][yRows];
        int k = 0;
        for (int i = 0; i < xCols; i++){
            for(int j = 0; j < yRows; j++){
                c[i][j] = getCell(i,j,k);
                k++;
            }
        }
        return c;
    }

    public Cell getCell(int i, int j, int k) {
        return new Cell(i, j, k);
    }

}


class SuperMatrix extends Matrix {
    @Override
    public Cell getCell(int i, int j, int k) {
        Cell c = super.getCell(i, j, k);
        modify(c);
        return c;
    }
}