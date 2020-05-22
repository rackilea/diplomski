DefaultTableModel model = new DefaultTableModel(
        new String[]{"Action"}, 0);
JXTable table = new JXTable(model);
Object[] keys = table.getActionMap().allKeys();
for (Object key : keys) {
    model.addRow(new Object[]{table.getActionMap().get(key)});
}
StringValue sv = new StringValue() {

    @Override
    public String getString(Object value) {
        if (value instanceof Action) {
            return (String) ((Action) value).getValue(Action.NAME);
        }
        return StringValues.TO_STRING.getString(value);
    }

};
table.getColumn(0).setCellRenderer(new DefaultTableRenderer(sv));
table.setDragEnabled(true);
table.setTransferHandler(new XTableTransferHandler());