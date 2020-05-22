final int columnIndex = 2; //index of your column
//listener that changes selection.
ListSelectionListener selectParticularColumnListener = new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //this method should have access to your JTable
        table.setColumnSelectionInterval(columnIndex, columnIndex);
    }
};

//listen for row selection changes
table.getSelectionModel().addListSelectionListener(selectParticularColumnListener);
//listen for column selection changes
table.getColumnModel().getSelectionModel().addListSelectionListener(selectParticularColumnListener);