editor.addCellEditorListener(new CellEditorListener() {
    @Override
    public void editingStopped(ChangeEvent e) {
        System.out.println("Editing stopped");
        TableCellEditor editor = (TableCellEditor) e.getSource();
        Object value = editor.getCellEditorValue();
        System.out.println("Selected value = " + value);
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
    }
});