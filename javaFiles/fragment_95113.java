@XmlRootElement(name = "AutoList")
public class AutoModel extends AbstractTableModel {
    String[] columnNames = {"VIN", "Make", "Model", "Year"};

    @XmlElement(name = "Auto")
    protected List<Auto> autos;

    public AutoModel() {
        autos = new ArrayList<Auto>();
    }

    @Override
    public int getRowCount() {
        return autos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = autos.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0 : value = auto.getVIN(); break;
            case 1 : value = auto.getMake(); break;
            case 2 : value = auto.getModel(); break;
            case 3 : value = auto.getYear(); break;
        }
        return value;
    }
}