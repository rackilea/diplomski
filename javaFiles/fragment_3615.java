// some data
User[] users = new User[] { 
        new User("Clara Zetkin", "CZ"),
        new User("Rosa Luxemburg", "RL"),
        new User("Susan Sontag", "SS"),
};
// the renderer for use in the editor
ListCellRenderer comboRenderer = new DefaultListCellRenderer() {

    @Override
    public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof User) {
            setToolTipText(((User) value).getName());
            value = ((User) value).getInitials();
        } else {
            setToolTipText(null);
        }
        return super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
    }

};
JComboBox editingCombo = new JComboBox(users);
editingCombo.setRenderer(comboRenderer);

JTable table = new JTable(3, 2);
// set up the editor for the first column
table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(editingCombo));
// the renderer to use in the table
TableCellRenderer renderer = new DefaultTableCellRenderer() {

    @Override
    protected void setValue(Object value) {
        if (value instanceof User) {
            setToolTipText(((User) value).getInitials());
            value = ((User) value).getName();
        } else {
            setToolTipText(null);
        }
        super.setValue(value);
    }

};
table.getColumnModel().getColumn(0).setCellRenderer(renderer);