File file = new File(System.getProperty("user.dir") 
                            + "/src/main/uat/testdata/FreeTestData.xlsx");

if(!file.exists())
{
    file.createNewFile();
}
else
{
    file.delete();
    file.createNewFile();
}

Workbook workbook = new XSSFWorkbook();

Sheet sheet = workbook.createSheet();

Row headerRow = sheet.createRow(0);

headerRow.createCell(0).setCellValue("Setupid");
headerRow.createCell(1).setCellValue("Request");

int cellCount = 10;

for (int i = 1; i <= cellCount; i++)
{

    Row row = sheet.createRow(i);

    row.createCell(0).setCellValue("cell " + i);
    row.createCell(1).setCellValue("cell " + i);

}

FileOutputStream fos = new FileOutputStream(file);

workbook.write(fos);

fos.close();

workbook.close();