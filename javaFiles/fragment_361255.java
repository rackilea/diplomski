import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.util.cellwalk.*;

import org.apache.poi.xssf.usermodel.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import java.io.*;
import java.util.*;

class ExcelRenameTableColumns {

 static void translateHeaders(Sheet sheet, final Map<String,String> header, int headerrownumber) {
  CellRangeAddress address = new CellRangeAddress(
   headerrownumber, headerrownumber, 
   0, sheet.getRow(headerrownumber).getLastCellNum());

  CellWalk cellWalk = new CellWalk (sheet, address);
  cellWalk.traverse(new CellHandler() {
   public void onCell(Cell cell, CellWalkContext ctx) {
    String val = cell.getStringCellValue();
    if (header.containsKey(val)) {
     cell.setCellValue(header.get(val));
    }
   }
  });
 }

 static void updateHeaders(XSSFTable table) {
  XSSFSheet sheet = (XSSFSheet)table.getParent();
  CellReference ref = table.getStartCellReference();

  if (ref == null) return;

  int headerRow = ref.getRow();
  int firstHeaderColumn = ref.getCol();
  XSSFRow row = sheet.getRow(headerRow);
  DataFormatter formatter = new DataFormatter();

System.out.println(row.getCTRow().validate()); // false!

  if (row != null /*&& row.getCTRow().validate()*/) {
   int cellnum = firstHeaderColumn;
   CTTableColumns ctTableColumns = table.getCTTable().getTableColumns();
   if(ctTableColumns != null) {
    for (CTTableColumn col : ctTableColumns.getTableColumnList()) {
     XSSFCell cell = row.getCell(cellnum);
     if (cell != null) {
      col.setName(formatter.formatCellValue(cell));
     }
     cellnum++;
    }
   }
  }
 }

 public static void main(String[] args) throws Exception {

  String templatePath = "dummy_template.xlsx";
  String outputPath = "result.xlsx";

  FileInputStream inputStream = new FileInputStream(templatePath);
  Workbook workbook = WorkbookFactory.create(inputStream);
  Sheet sheet = workbook.getSheetAt(0);

  Map<String, String> header = new HashMap<String, String>();
  header.put("textone", "Spalte eins");
  header.put("texttwo", "Spalte zwei");
  header.put("textthree", "Spalte drei");

  translateHeaders(sheet, header, 3);

  XSSFTable table = ((XSSFSheet)sheet).getTables().get(0);

  updateHeaders(table);

  FileOutputStream outputStream = new FileOutputStream(outputPath);
  workbook.write(outputStream);
  outputStream.close();
  workbook.close();

 }
}