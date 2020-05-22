public static class PatientTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "First name",
        "Last name",
        "MHN"
    };

    private List<PatientData> rowData;

    public PatientTableModel() {
        rowData = new ArrayList<>(25);
    }

    public void add(PatientData... pd) {
        add(Arrays.asList(pd));
    }

    public void add(List<PatientData> pd) {
        rowData.addAll(pd);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public PatientData getPatientDataAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PatientData pd = getPatientDataAt(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = pd.getFirstName();
                break;
            case 1:
                value = pd.getLastName();
                break;
            case 2:
                value = pd.getMHN();
                break;
        }
        return value;
    }

}