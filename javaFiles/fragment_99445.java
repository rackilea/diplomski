import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.CellUtil;

import java.util.concurrent.ThreadLocalRandom;

public class CreateExcelCellsByIndex {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet();

  //put content in R3C2:
  Cell cell = CellUtil.getCell(CellUtil.getRow(3-1, sheet), 2-1); //-1 because apache poi's row and cell indexes are 0 based
  cell.setCellValue("R3C2");

  //put content in 10 random cells:
  for (int i = 1; i < 11; i++) {

   int r = ThreadLocalRandom.current().nextInt(4, 11);
   int c = ThreadLocalRandom.current().nextInt(1, 6);
   cell = CellUtil.getCell(CellUtil.getRow(r-1, sheet), c-1);
   String cellcontent = "";
   if (cell.getCellTypeEnum() == CellType.STRING) {
    cellcontent = cell.getStringCellValue() + " ";
   }
   cell.setCellValue(cellcontent + i + ":R"+r+"C"+c);
  }

  workbook.write(new FileOutputStream("CreateExcelCellsByIndex.xlsx"));
  workbook.close();

 }

}