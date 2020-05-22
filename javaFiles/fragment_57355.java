static DefaultTableModel TableModel = new DefaultTableModel(dataInfo, columns){
public Class getColumnClass(int column) {
Class returnValue;
// Verifying that the column exists (index > 0 && index < number of columns
if ((column >= 0) && (column < getColumnCount())) {
  returnValue = getValueAt(0, column).getClass();
    //you need to add the .getclass method which 
                  //gets the variable to the left.
 } else {
  // Returns the class for the item in the column   
 returnValue = Object.class;
                }
 return returnValue;
              }
            };