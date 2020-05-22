public class MyDataTableModel extends AbstractTableModel {

    private List<Data> dataList;

    public MyDataTableModel() {
        dataList = new ArrayList<Data>(25);
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "Name";
                break;
            case 1:
                name = "Phone";
                break;
            case 2:
                name = "Address";
                break;
            case 3:
                name = "City";
                break;
            case 4:
                name = "State";
                break;
            case 5:
                name = "Postal Code";
                break;
            case 6:
                name = "Link";
                break;
        }
        return super.getColumnName(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        Data data = dataList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = data.getName();
                break;
            // Other case statements per column...
        }
        return value;
    }

    public void add(Data data) {
        dataList.add(data);
        int index = dataList.size() - 1;
        fireTableRowsInserted(index, index);
    }
}