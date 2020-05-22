DefaultTableModel model = new DefaultTableModel(data, columnNames) {
    @Override
    public Class<?> getColumnClass(int column) {
        // return getValueAt(0, column).getClass(); NO! Never do we have to do this.
        switch (column) {
            case 0: return String.class;
            case 1: return Integer.class;
            ...
            case 7: return String.class;
                default: throw new ArrayIndexOutOfBoundsException(column);
    }
};