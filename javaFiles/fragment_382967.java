table.setDefaultEditor(Boolean.class, new DefaultCellEditor(new JCheckBox()) {

    @Override
    public boolean stopCellEditing() {
        String value = JOptionPane.showInputDialog(...);
        ...
        return super.stopCellEditing();
    }
});