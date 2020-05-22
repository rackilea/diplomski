import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Rename {


    static HSSFRow row_read = null;
    static HSSFRow row_write = null;
    static HSSFCell cell;

    static FileOutputStream output = null;
    static HSSFWorkbook workbook_read = null;
    static HSSFWorkbook workbook_write = null;
    static HSSFSheet sheet_read = null;
    static HSSFSheet sheet_write = null;

    public static void removechar() {
        try {
            FileInputStream input = new FileInputStream("D://test_input.xls");
            workbook_read = new HSSFWorkbook(input);
            sheet_read = workbook_read.getSheet("Report");
            workbook_write = new HSSFWorkbook();
            sheet_write = workbook_write.createSheet("Test");
            DataFormatter formatter = new DataFormatter();
            int rowCount = sheet_read.getLastRowNum();
            System.out.println(rowCount);
            for (int rowNum = 0; rowNum <= rowCount; rowNum++) {
                row_read = sheet_read.getRow(rowNum);
                row_write = sheet_write.createRow(rowNum);
                for (int cellNum = 0; cellNum <= 7; cellNum++) {
                    // Cell cell = null;
                    String temp = formatter.formatCellValue(row_read.getCell(cellNum));
                    // System.out.println(temp);
                    String temp1 = temp.replaceAll("\'", "");
                    String temp2 = temp1.replaceAll("\"", "");
                    System.out.println(temp2);
                    cell = row_write.createCell(cellNum);
                    cell.setCellValue(temp2);
                }
            }

            output = new FileOutputStream("D://test_output.xls");
            workbook_write.write(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] argv) throws IOException {
        Rename.removechar();
    }
}