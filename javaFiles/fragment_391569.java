package AsciiToDIVs;

public class Cell {
    public char Character;
    public CellGrid parentGrid;
    private int rowIndex;
    private int colIndex;

    public Cell(char Character, CellGrid parent, int rowIndex, int colIndex)
    {
        this.Character = Character;
        this.parentGrid = parent;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }
}