for( i=0; i<10; i++){
     HSSFRow row = sheetTest.createRow(i);
     for (j = 0; j < 10; j++) {
         System.out.println(k);
         cell[k] =  row.createCell(j);
         cell[k].setCellValue(k);
         k++;
     }
 }