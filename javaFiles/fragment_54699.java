import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelExample {

    public static void main(String[] args) {
        InputStream inp;
        try {
            inp = new FileInputStream("workbook.xls");

        Workbook wb = new HSSFWorkbook(inp);
        CreationHelper createHelper = wb.getCreationHelper();

        Sheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {

            Cell cell = row.getCell(1);
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("hh:mm:ss"));
            cell.setCellStyle(cellStyle);

          }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wb.write(fileOut);
        fileOut.close();
        System.out.println("Done...");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}