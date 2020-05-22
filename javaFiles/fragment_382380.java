public class SummaryTableModel extends AbstractTableModel {

    private Map<String, Integer> data;
    private List<String> keyMap;

    public SummaryTableModel(Map<String, Integer> data) {
        this.data = new HashMap<>(data);
        keyMap = new ArrayList<>(data.keySet());
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = Object.class;
        switch (columnIndex) {
            case 0:
                type = String.class;
                break;
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = keyMap.get(rowIndex);
                break;
            case 1:
                String key = keyMap.get(rowIndex);
                value = data.get(key);
                break;
        }
        return value;
    }

}