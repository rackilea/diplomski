JTextField field = new JTextField();
field.getDocument().addUndoableEditListener(new UndoableEditListener() {

    @Override
    public void undoableEditHappened(UndoableEditEvent arg0) {
        System.out.println("profit");
    }
});
DefaultCellEditor editor = new DefaultCellEditor(field);
table.getColumnModel().getColumn(COLUMN_INDEX).setCellEditor(editor);