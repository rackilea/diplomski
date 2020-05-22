public void removeRow(DefaultTableModel model, int modelRow)
{
    Object rowID = model.getValueAt(modelRow, theColumn);

    // your code to delete row from database

    if (row delected successfully)
        model.removeRow(modelRow);
}