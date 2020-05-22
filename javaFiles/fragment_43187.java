// create a label that will be using the run-time font
JLabel prototypeLabel = new JLabel("Not Applicable")

// get the labels preferred sizes
int preferredWidth = prototypeLabel.getPreferredSize().getWidth();
int preferredHeight = prototypeLabel.getPreferredSize().getHeight();

// set the sizes of the table's row and columns
myTable.setRowHeight(preferredHeight);

for(TableColumn column : myTable.getColumnModel.getColumns()){
   column.setPreferredWidth(preferredWidth);        
}