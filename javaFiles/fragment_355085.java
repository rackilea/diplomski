// anonymous inner class example
TableModel ss = new DefaultTableModel(myArray[][], myHeaderArray[]) {
    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
};