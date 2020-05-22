File f = new File(directory+"users.xlsx");

FileInputStream fileInputStream = new FileInputStream(f);

Workbook workbook = WorkbookFactory.create(fileInputStream);
fileInputStream.close();
sheet = workbook.getSheetAt(0);
Row row = sheet.getRow(4);
for(int i = 0; i<5; i++)
{
Cell cell = row1.getCell(i);
cell.setCellValue(formattedDate);
cell.setCellStyle(normalStyle);
}

 FileOutputStream out = new FileOutputStream(f, false);
               workbook.write(out);
               out.close();