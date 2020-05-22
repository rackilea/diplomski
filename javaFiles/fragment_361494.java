private void setTableData() {        
    Object data[][] = students.Select(Names.getSelectedItem().toString());

    this.Model = new Model(data);

    TableColumn column = this.MessagesTable.getColumnModel().getColumn(0);
    column.setPreferredWidth(20);
    this.MessagesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.MessagesTable.setSelectionBackground(getBackground());
    this.MessagesTable.setSelectionForeground(getForeground());

    this.MessagesTable.setModel(this.MyModel);
}