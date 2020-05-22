for(int x = 0;x < table.getNumberOfRows(); x++){
          XWPFTableRow row = table.getRow(x);
          int numberOfCell = row.getTableCells().size();
          for(int y = 0; y < numberOfCell ; y++){
              XWPFTableCell cell = row.getCell(y);

              cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(2000));
          } 
        }