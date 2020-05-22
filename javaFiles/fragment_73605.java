` for (int i = 0; i <  model.getRowCount()+1; i++) {
      SSFRow excelRow = excelSheet.createRow(i);
      for (int j = 0; j <  model.getColumnCount(); j++) {
          if(i == 0){
                XSSFCell excelCell = excelRow.createCell(j);
                excelCell.setCellValue(model.getColumnName(j));
           }else{
                 XSSFCell excelCell = excelRow.createCell(j);
                 excelCell.setCellValue(model.getValueAt(i-1, j).toString());
                 }
        }
  }`