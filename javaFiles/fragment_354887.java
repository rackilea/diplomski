Sheet s = wb.createSheet();
for (int i=0; i<firstList.size(); i++) {
   Row r = s.createRow(i);
   r.createCell(0).setCellValue( list1.get(i) );
   r.createCell(1).setCellValue( list2.get(i) );
   r.createCell(2).setCellValue( list3.get(i) );
}