XSSFWorkbook workbook = new XSSFWorkbook(new File("test.xlsx"));
int numberOfSheets = workbook.getNumberOfSheets();
for(int sheetIdx = 0; sheetIdx < numberOfSheets; sheetIdx++) {
    XSSFSheet sheet = workbook.getSheetAt(sheetIdx);
    List<XSSFTable> tables = sheet.getTables();
    for(XSSFTable t : tables) {
        System.out.println(t.getDisplayName());
        System.out.println(t.getName());
        System.out.println(t.getNumerOfMappedColumns());
    }
}