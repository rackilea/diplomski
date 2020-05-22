String[] header = new String[] {"Entry date", "Name", "Address", "Phone number"};
DataObjectTableModel<Customer> model = new DataObjectTableModel<>(Arrays.asList(header)) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Date.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
                default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = getDataObject(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getEntryDate();
            case 1: return customer.getName();
            case 2: return customer.getAddress();
            case 3: return customer.getPhoneNumber();
                default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex < 0 || columnIndex >= getColumnCount()) {
            throw new ArrayIndexOutOfBoundsException(columnIndex);
        } else {
            Customer customer = getDataObject(rowIndex);
            switch (columnIndex) {
                case 0: customer.setEntryDate((Date)aValue); break;
                case 1: customer.setName((String)aValue); break;
                case 2: customer.setAddress((String)aValue); break;
                case 3: customer.setPhoneNumber((String)aValue); break;
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
};