public static class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private Object editorValue;
    private JLabel entryView;
    JComponent editor;

    public MyCellEditor() {
        editor = new JPanel();
        entryView = new JLabel();
        editor.add(entryView);
        Action add = createAddAction();
        editor.add(new JButton(add));
        Action remove = createRemoveAction();
        editor.add(new JButton(remove));
    }

    public Action createRemoveAction() {
        Action remove = new AbstractAction("Remove Entry") {

            @Override
            public void actionPerformed(ActionEvent e) {
                editorValue = MyTableModel.Modify.REMOVE;
                fireEditingStopped();
            }

        };
        return remove;
    }

    public Action createAddAction() {
        Action add = new AbstractAction("Add Entry") {

            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Add entry: ");

                if ((input != null) && (input.length() > 0)) {
                    editorValue = new MyTableModel.NewItem(input);
                    fireEditingStopped();
                } else {
                    fireEditingCanceled();
                }

            }

        };
        return add;
    }

    @Override
    public Object getCellEditorValue() {
        return editorValue;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        entryView.setText(value != null ? value.toString() : "");
        return editor;
    }


}