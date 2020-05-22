model.addTableModelListener(new TableModelListener() {

     @Override
     public void tableChanged(TableModelEvent e) {
          int rowFirstIndex = e.getFirstRow();
          int rowLastIndex = e.getLastRow();

          DefaultTableModel model = (DefaultTableModel) e.getSource();
           if(e.getType()==TableModelEvent.UPDATE)
            {
                int updatedColIndex = e.getColumn();
                String updateColmn = table.getColumnName(updatedColIndex);
                String updatedValue = (String) model.getValueAt(rowFirstIndex, updatedColIndex);
                System.out.println("column: "+updateColmn+" value: "+updatedValue);
                updateDB(updateColmn, updatedValue);
            }

            else if(e.getType()==TableModelEvent.INSERT)
            {
             for(int i= rowFirstIndex; i <= rowLastIndex ; i++)  
              {   
                  Vector rowData = (Vector) model.getDataVector().get(i);

                  Map<String, String>dataMap = new HashMap<>();

                  for(int j=0; j < rowData.size() ; j++)
                    dataMap.put(table.getColumnName(j), (String) rowData.get(j));

                  InsertToDB(dataMap); // now it contains columndName corresponding to row value

              }
          }
         }
     });