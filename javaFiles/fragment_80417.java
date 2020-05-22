public static void ReadFile() throws Exception {
FileInputStream file = new FileInputStream(new File("C:xx"));
XSSFWorkbook wb = new XSSFWorkbook(file);
XSSFSheet sheet = wb.getSheetAt(0);
XSSFRow row = null;
XSSFCell cell = null;

DataFormatter formatter = new DataFormatter();
String val;

for (Iterator<Row> iterator = sheet.rowIterator(); iterator.hasNext();) {
    row = (XSSFRow) iterator.next();

    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
        cell = row.getCell(i);           
        val = formatter.formatCellValue(cell);
        /* System.out.println(val); */

        if (val.equals("ABC01")) {
            i++;

            cell = row.getCell(i);
            val = formatter.formatCellValue(cell);

            if (val.equals("2018")) {
                System.out.print("XX");
            }
        }


        }

    }
}