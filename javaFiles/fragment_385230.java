private void addingPartsChangeEvent() 
   {

      Action actionProd = new AbstractAction() 
      {

         public void actionPerformed(ActionEvent e) 
         {
            try 
            {
               boolean newChk = false;
               TableCellListener tcl = (TableCellListener) e.getSource();
               int selectedRow = tcl.getRow();
               int selectedCol = tcl.getColumn();

               if (selectedCol == 4) 
               {
                  Object partO = tcl.getNewValue();
                  String design = null;
                  String partStr = partO.toString();
                  tblDetailInfoParts.setValueAt(partStr,selectedRow, 15) ;
               }

            } 
            catch (Exception ex) 
            {
               ex.printStackTrace();
            }
         }
      };
      TableCellListener tclProd = new TableCellListener(tblDetailInfoParts,
      actionProd);
    }