public class ExcelWriter {
    static final String FILE_PATH_LINUX = "/tmp/MyFirstExcel.xlsx";
    static final String FILE_PATH_WIN = "C:/Users/Sonic/MyFirstExcel.xlsx"; // note: replace Window's backslash '\' by either double-backslash '\\' or single forward-slash '/'

    public static void main(String[] args) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("FirstExcelSheet"); // first sheet create
        XSSFRow row = sheet.createRow(0); // first row create - A
        XSSFCell cell = row.createCell(0); // first cell create - A-1        
        cell.setCellValue("Tester"); // give data into A-1 cell

        // Output as an excel file
        workbook.write(new FileOutputStream(FILE_PATH_WIN));
        workbook.close();
    }
}