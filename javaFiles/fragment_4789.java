import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.*;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

public class TestPivotTable {
 public static void main(String[] args) throws Exception {
  Workbook wb = new XSSFWorkbook();
  Object[][] data = new Object[][]{
   {"AAA","BBB","CCC","DDD","EEE","FFF","GGG","HHH"}, 
   {"TOM","DUMMY","VAL","1001683","Description1","27/04/2017","CAT",780936.58},
   {"TOM","DUMMY","VAL","1001695","Description2","27/04/2017","CAT",136.28},
   {"HARRY","DUMMY1","VAL1","1001692","Description3","03/05/2017","CAT1",191468.21},
   {"HARRY","DUMMY1","VAL1","1001698","Description4","04/05/2017","CAT1",10.11}
  };

  XSSFSheet sheet = (XSSFSheet) wb.createSheet("data");
  XSSFSheet pivot = (XSSFSheet) wb.createSheet("summary");
  for(Object[] dataRow : data){
   XSSFRow row = sheet.createRow(sheet.getPhysicalNumberOfRows());
   for(Object dataCell : dataRow){
    XSSFCell cell = row.createCell(row.getPhysicalNumberOfCells());
    if (dataCell instanceof String) {
     cell.setCellValue((String)dataCell);
    } else if (dataCell instanceof Double) {
     cell.setCellValue((Double)dataCell);
    }
   }
  }

  AreaReference areaReference = new AreaReference("A1:H"+ (sheet.getLastRowNum() + 1), SpreadsheetVersion.EXCEL2007);
  XSSFPivotTable pivotTable =  pivot.createPivotTable(areaReference, new CellReference("A1"), sheet);
  pivotTable.getCTPivotTableDefinition().setRowHeaderCaption("AAA");

  List<Integer> iterList = new ArrayList<Integer>();
  iterList.add(0);
  iterList.add(1);
  iterList.add(2);
  iterList.add(3);
  iterList.add(4);
  iterList.add(5);
  iterList.add(6);

  //set updated pivot table version to 6
  //necessary to make extended pivot table setting available
  pivotTable.getCTPivotTableDefinition().setUpdatedVersion((short)6); 

  for (Integer j : iterList) {

   //create row label - apache poi creates as much fields for each as rows are in the pivot table data range
   pivotTable.addRowLabel(j);

   //determine unique labels in column j
   TreeSet<String> uniqueItems = new java.util.TreeSet<String>();
   for (int r = areaReference.getFirstCell().getRow()+1; r < areaReference.getLastCell().getRow()+1; r++) {
    uniqueItems.add(sheet.getRow(r).getCell(j).getStringCellValue());
   }
   System.out.println(uniqueItems);

   //build pivot table and cache
   CTPivotField ctPivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(j);
   int i = 0;
   for (String item : uniqueItems) {
    //take the items as numbered items: <item x="0"/><item x="1"/>
    ctPivotField.getItems().getItemArray(i).unsetT();
    ctPivotField.getItems().getItemArray(i).setX((long)i);
    //build a cache definition which has shared elements for those items 
    //<sharedItems><s v="TOM"/><s v="HARRY"/></sharedItems>
    pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldArray(j)
     .getSharedItems().addNewS().setV(item);
    i++;
   }

   //ctPivotField.setAutoShow(false);
   ctPivotField.setDefaultSubtotal(false);
   //ctPivotField.setSubtotalTop(false);
   //ctPivotField.setSubtotalCaption(null);
   //ctPivotField.setCompact(false);
   ctPivotField.setOutline(false);

   //remove further items
   if (ctPivotField.getDefaultSubtotal()) i++; //let one default item be if there shall be subtotals
   for (int k = ctPivotField.getItems().getItemList().size()-1; k >= i; k--) {
    ctPivotField.getItems().removeItem(k);
   }
   ctPivotField.getItems().setCount(i);

   //set <x14:pivotField fillDownLabels="1"/> for each CTPivotField
   //this is the "Repeat All Items Label" setting
   CTExtensionList extList = ctPivotField.addNewExtLst();
   CTExtension ext = extList.addNewExt();
   String extXML = 
      "<x14:pivotField"
    + " xmlns:x14=\"http://schemas.microsoft.com/office/spreadsheetml/2009/9/main\""
    + " fillDownLabels=\"1\"/>";
   org.apache.xmlbeans.XmlObject xlmObject = org.apache.xmlbeans.XmlObject.Factory.parse(extXML);
   ext.set(xlmObject);
   ext.setUri("{2946ED86-A175-432a-8AC1-64E0C546D7DE}");  

  }

  System.out.println("----end---");

  pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 7, "SUM");

  FileOutputStream fileOut = new FileOutputStream("newoutputfile.xlsx");
  wb.write(fileOut);
  fileOut.close();
  wb.close();
 }
}