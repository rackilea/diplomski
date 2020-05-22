class MyTableModel extends DefaultTableModel {
    public static final String[] COLUMNS = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static final int START_TIME = 8;
    private static final int END_TIME = 17;

    public MyTableModel() {
        super(COLUMNS, 0);
        for (int i = START_TIME; i < END_TIME + 1; i++) {
            Object[] rowData = {String.valueOf(i), "", "", "", "", ""};
            addRow(rowData);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }
}