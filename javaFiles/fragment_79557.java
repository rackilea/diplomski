DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Image"}, 0) {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 1 ? Icon.class : super.getColumnClass(columnIndex);
    }
};