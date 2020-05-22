public class PropertiesTableModel extends AbstractTableModel {
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // previous stuff
        if (columnIndex == 2) {
            // return the actually selected value, 
            // not the first value of the list!
            // also the values changed by setValueAt() must be considered.
            return null; // implement it!
        }
    }

    public List<Object> getPossibleValues(int row, int column) {
        // this method should return possible values to select.
        // if cell has no possible values and should be editeb 
        // by a text field this methos should return null
        if (column == 2) {
             Field field= (Field) fieldList.get(rowIndex);
             if (field.getFieldDef().getListValue().size() > 0) {
                 return field.getFieldDef().getListValue();
             }
             return null; // probably something else for non-list values
         }
    }

    public void setValueAt(int row, int column) {
        // you need to store the value chosen by the user
    }
}