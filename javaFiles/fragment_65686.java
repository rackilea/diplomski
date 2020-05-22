private void searchTable()
{
  String id = inputIdField.getText();

  for(int row = 0; row <= listAllTable.getRowCount() - 1; row++) 
  {
      System.out.println(row);
      String strVal = null == listAllTable.getValueAt(row, 0)? null : listAllTable.getValueAt(row, 0).toString();
      if(id.equals(strVal)) 
      {
        listAllTable.scrollRectToVisible(listAllTable.getCellRect(row, 0, true));
        listAllTable.setRowSelectionInterval(row, row);
        for (int i = 0; i <= listAllTable.getColumnCount() - 1; i++) 
        {

            listAllTable.getColumnModel().getColumn(i).setCellRenderer(new HighlightRenderer());
        }
    }
    else
    {

    }
  }
}