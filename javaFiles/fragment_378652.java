import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//..
HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet sheet = workbook.createSheet("FuSsA sheet");
//Create a new row in current sheet
Row row = sheet.createRow(0);
//Create a new cell in current row
Cell cell = row.createCell(0);
//Set value to new value
cell.setCellValue("Slim Shady");
    try {
        FileOutputStream out = 
                new FileOutputStream(new File("C:\\new.xls"));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }