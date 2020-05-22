private void changeTable() {
    // create a new table model
    MyTableModel newModel = new MyTableModel(pertinentParameters);

    // use the new model to set the model of the displayed JTable
    accountTable.setModel(newModel);
}