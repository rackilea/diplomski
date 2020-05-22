public void valueChanged(ListSelectionEvent event)
{
    int index = table.getSelectedRow();

    if (index != -1)
    {
        int row = table.convertRowIndexToModel(index);
        comboBox.setSelectedIndex(row);
    }
}