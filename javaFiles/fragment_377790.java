private void activePatients() {
    RowFilter<PatientTableModel, Integer> rf = new RowFilter<PatientTableModel, Integer>() {

        @Override
        public boolean include(RowFilter.Entry<? extends PatientTableModel, ? extends Integer> entry) {
            int row = entry.getIdentifier();
            PatientData pd = entry.getModel().getPatientDataAt(row);
            return pd.getActiveStatus() == 1;
        }

    };
    ((TableRowSorter) patients.getRowSorter()).setRowFilter(rf);
    setPatientCount();
}

private void inActivePatients() {
    RowFilter<PatientTableModel, Integer> rf = new RowFilter<PatientTableModel, Integer>() {

        @Override
        public boolean include(RowFilter.Entry<? extends PatientTableModel, ? extends Integer> entry) {
            int row = entry.getIdentifier();
            PatientData pd = entry.getModel().getPatientDataAt(row);
            return pd.getActiveStatus() != 1;
        }

    };
    ((TableRowSorter) patients.getRowSorter()).setRowFilter(rf);
    setPatientCount();
}

public void allPatients() {
    ((TableRowSorter) patients.getRowSorter()).setRowFilter(null);
    setPatientCount();
}