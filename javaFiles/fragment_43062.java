import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TextBoldItalic {

  public static void main(String[] args) throws Exception {

    XSSFWorkbook wb = new XSSFWorkbook();
    Sheet sheet = wb.createSheet();
    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);

    XSSFFont fontBold = wb.createFont();
    fontBold.setBold(true);
    XSSFFont fontItalic = wb.createFont();
    fontItalic.setItalic(true);
    XSSFFont fontBoldItalic = wb.createFont();
    fontBoldItalic.setBold(true);
    fontBoldItalic.setItalic(true);

    XSSFRichTextString cellValue = new XSSFRichTextString();
    cellValue.append("This is ", fontBold);
    cellValue.append("sample ", fontItalic);
    cellValue.append("content", fontBoldItalic);
    cell.setCellValue(cellValue);

    OutputStream fileOut = new FileOutputStream("TextBoldItalic.xlsx");
    wb.write(fileOut);
    wb.close();
  }
}