tableCA = new JTable(modelTableCA){
    public boolean isCellEditable(int row, int column){
        if (tableCA.getValueAt(row, 0).equals("214") || tableCA.getValueAt(row, 0).equals("A00") || tableCA.getValueAt(row, 0).equals("A30") || tableCA.getValueAt(row, 0).equals("B00")) {
            if (column == 0 || column == 4 || column == 5 || column == 6 || column == 7) {
                return false;
            } else {
                return true;
            }
        } else {
            if (column == 7) {
                return false;
            } else {
                return true;
            }
        }
    }
};