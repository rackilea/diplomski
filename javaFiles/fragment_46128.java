public abstract class CommonTableModel {
    private String[] columnNames;
    private Object[][] data;

    protected CommonTableModel(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }
}