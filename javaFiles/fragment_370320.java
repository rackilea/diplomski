JTable table;

     table = new JTable(dataVector, columnNamesVector){

      public Class getColumnClass(int column)
      {
        for (int row = 0; row < getRowCount(); row++)
        {
            Object o = getValueAt(row, column);

            if (o != null)
            {
                return o.getClass();
            }
        }

        return Object.class;
      }
   };

 //call setReorderingAllowed here

table.getTableHeader().setReorderingAllowed(false);