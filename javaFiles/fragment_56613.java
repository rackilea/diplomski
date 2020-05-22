public class MyTableModel implements TableModel {

    private String[] headers;        //This line.
    private Object[][] tableData;


    public MyTableModel(String[] headers, Object[][] tableData) {
        this.headers = headers;
        this.tableData = tableData;
    }

    @Override
    public int getColumnCount() {
        return headers.length;        //<<This line of code
    }

    public static void main(String[] args) {
        String fileName = "products.csv";

        String[] csvList = readCSV(fileName);

        String[] headers = Arrays.copyOfRange(csvList, 0, 10); 
        Object[][] tableData = ..MyTableModel.. // code to create this

        // now create a table model with your data and use it.
        MyTableModel myTableModel = new MyTableModel(headers, tableData);
    }

    private static String[] readCSV(String file) {
        String fileString = "";
        //Some code to fill the list.
        return fileString;
    }

}