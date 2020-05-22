ServletOutputStream serv = response.getOutputStream();
response.setContentType("text/x-csv");
response.addHeader("Content-Disposition",
        "attachment; filename=ListofContracts.csv");
HSSFSheet sheet = wb.getSheetAt(0);

for (int i = 0; i <= sheet.getLastRowNum(); i++) {
    HSSFRow row = sheet.getRow(i);

    for (short j = 0; j <= row.getLastCellNum(); j++) {
        HSSFCell cell = row.getCell(j);
        strBuff.append(cell.getStringCellValue() + " , ");
    }

}
serv.write(strBuff.toString().getBytes());