public class CSVTable {

    private String[][] csvTable = null;

    public CSVTable(int columns)
    {
        csvTable = new String[columns][2];
    }

    public String[][] getCSVTable()
    {
        return this.csvTable;
    }

    public void setCSVTable(String[][] csvTable)
    {
        this.csvTable = csvTable;
    }
}