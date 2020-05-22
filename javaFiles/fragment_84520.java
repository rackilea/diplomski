employee.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            // update the detail table model based on the selected employee
            fireTableDataChanged();
        }
    }
});