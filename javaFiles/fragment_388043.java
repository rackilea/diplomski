public void setExcelRows(HSSFWorkbook wb, List<Employee> empList) {
    int record = 1; int sheetNum = 0;
    HSSFSheet sheet = wb.createSheet("Employee List "+sheetNum);
    setExcelHeader(sheet);
    for (Employee a : empList) {
         if (record == 26){
             sheetNum++;
             sheet= wb.createSheet("Employee List "+ sheetNum);
             setExcelHeader(sheet);
             record = 1;
         }        
         HSSFRow excelRow = sheet.createRow(record++);
        excelRow.createCell(1).setCellValue(a.getId());
 }