import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.*;

import java.util.List;
import java.util.Collections;

class ExcelMergedRegions {

 public static void main(String[] args) throws Exception {

  Workbook workbook  = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet();

  sheet.addMergedRegion(new CellRangeAddress(1,4,2,2)); //C2:C5
  sheet.addMergedRegion(new CellRangeAddress(1,4,1,1)); //B2:B5
  sheet.addMergedRegion(new CellRangeAddress(1,4,0,0)); //A2:A5
  sheet.addMergedRegion(new CellRangeAddress(5,8,2,2)); //C6:C9
  sheet.addMergedRegion(new CellRangeAddress(5,8,1,1)); //B6:B9
  sheet.addMergedRegion(new CellRangeAddress(5,8,0,0)); //A6:A9
  sheet.addMergedRegion(new CellRangeAddress(9,12,2,2)); //C10:C13
  sheet.addMergedRegion(new CellRangeAddress(9,12,0,0)); //A10:A13

  sheet.addMergedRegion(new CellRangeAddress(1,5,3,4)); //D2:E6
  sheet.addMergedRegion(new CellRangeAddress(2,2,5,7)); //F3:H3

  List<CellRangeAddress> cellRangeAddressList = sheet.getMergedRegions();
  System.out.println(cellRangeAddressList);

  System.out.println("Sorted list:");

  Collections.sort(cellRangeAddressList, new CellRangeAddressComperator());
  System.out.println(cellRangeAddressList);

 }

 static class CellRangeAddressComperator implements java.util.Comparator<CellRangeAddress> {
  public int compare(CellRangeAddress o1, CellRangeAddress o2) {
   int r = 0;
   // first compare first rows
   r = o1.getFirstRow() - o2.getFirstRow();
   if (r != 0 ) return r;
   // if first rows are equal, compare first columns
   r = o1.getFirstColumn() - o2.getFirstColumn();
   if (r != 0 ) return r;
   // if first rows and first columns are equal, compare last rows
   r = o1.getLastRow() - o2.getLastRow();
   if (r != 0 ) return r;
   // if even last rows are equal, compare last columns
   r = o1.getLastColumn() - o2.getLastColumn();
   if (r != 0 ) return r;
   // if all is equal, return 0
   return r;
  }
 }
}