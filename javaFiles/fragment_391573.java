package AsciiToDIVs;

public class FoundObject {

    private int rowIndex;
    private int colIndex;
    private int width = 0;
    private int height = 0;

    public FoundObject(int rowIndex, int colIndex, int width, int height )
    {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.width = width;
        this.height = height;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}