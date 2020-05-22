import java.io.FileOutputStream;
import java.io.IOException;

    import org.apache.poi.hssf.usermodel.HSSFWorkbook;
    import org.apache.poi.ss.usermodel.Cell;
    import org.apache.poi.ss.usermodel.CellStyle;
    import org.apache.poi.ss.usermodel.DataFormat;
    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;


    public class ChangeXlxsDataFormat {

        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub

             Workbook wb = new HSSFWorkbook();
                Sheet sheet = (Sheet) wb.createSheet("format sheet");
                CellStyle style;
                DataFormat format = wb.createDataFormat();
                Row row;
                Cell cell;
                short rowNum = 0;
                short colNum = 0;

                row = sheet.createRow(rowNum);
                cell = row.createCell(colNum);

                style = wb.createCellStyle();
                        row = sheet.createRow(rowNum++);
                cell = row.createCell(colNum);

                style = wb.createCellStyle();
                style.setDataFormat(format.getFormat("0.00000000000"));
                cell.setCellStyle(style);
                cell.setCellValue(5.12345678908);
                row = sheet.createRow(rowNum++);
                cell = row.createCell(colNum);
                cell.setCellValue(2.12345678908);
                FileOutputStream fileOut = new FileOutputStream("test.xls");
                wb.write(fileOut);
                fileOut.close();


        }

    }