comboEmployees.setRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList list,
                                               Object value,
                                               int index,
                                               boolean isSelected,
                                               boolean cellHasFocus) {
        Employee employee = (Employee)value;
        value = employee.toStringDifferent();
        return super.getListCellRendererComponent(list, value,
                index, isSelected, csellHasFocus);
    }
});