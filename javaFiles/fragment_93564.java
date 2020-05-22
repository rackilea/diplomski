JButton removeEmployee = new JButton("Remove Selected");
    removeEmployee.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        try
        {/* here I added +1 because it moves the row to the selected row -1 
            I don't know why. But it now works well */
          resultSet.absolute(table.getSelectedRow()+1);
          resultSet.deleteRow();
          dTableModel.removeRow(table.getSelectedRow());
        } catch (SQLException e1)
        {
          e1.printStackTrace();
        }
      }
    });