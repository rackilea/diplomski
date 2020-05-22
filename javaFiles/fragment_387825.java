import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.filesystem.DirectoryNode;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.HyperlinkRecord;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFName;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.util.CellReference;

import java.util.List;
import java.util.ArrayList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class ExcelOpenHSSF {

 public static void main(String[] args) throws Exception {

  String fileName = "test(2).xls";

  try (InputStream is = new FileInputStream(fileName);
       POIFSFileSystem fileSystem = new POIFSFileSystem(is)) {

   //find workbook directory entry
   DirectoryNode directory = fileSystem.getRoot();
   String workbookName = "";
   for(String wbName : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
    if(directory.hasEntry(wbName)) {
     workbookName = wbName;
     break;
    }
   }
   InputStream stream = directory.createDocumentInputStream(workbookName);

   //loop over all records and manipulate if needed
   List<Record> records = new ArrayList<Record>();
   RecordFactoryInputStream recStream = new RecordFactoryInputStream(stream, true);

   //here we filter out the HyperlinkRecords that are between other records (NumberRecords and LabelSSTRecords in that case)
   //System.out.println prints the problematic records
   Record record1 = null;
   Record record2 = null;
   while ((record1 = recStream.nextRecord()) != null) {
    record2 = recStream.nextRecord();
    if (!(record1 instanceof HyperlinkRecord) && (record2 instanceof HyperlinkRecord)) {
     System.out.println(record1);
     System.out.println(record2);
     records.add(record1);  
    } else if ((record1 instanceof HyperlinkRecord) && !(record2 instanceof HyperlinkRecord)) {
     System.out.println(record1);
     System.out.println(record2);
     records.add(record2);  
    } else {
     records.add(record1);
     if (record2 != null) records.add(record2);
    }
   }

   //now create the HSSFWorkbook
   //see https://svn.apache.org/viewvc/poi/tags/REL_4_1_0/src/java/org/apache/poi/hssf/usermodel/HSSFWorkbook.java?view=markup#l322

   InternalWorkbook internalWorkbook = InternalWorkbook.createWorkbook(records);
   HSSFWorkbook wb = HSSFWorkbook.create(internalWorkbook);
   int recOffset = internalWorkbook.getNumRecords();

   Method convertLabelRecords = HSSFWorkbook.class.getDeclaredMethod("convertLabelRecords", List.class, int.class); 
   convertLabelRecords.setAccessible(true);
   convertLabelRecords.invoke(wb, records, recOffset);

   RecordStream rs = new RecordStream(records, recOffset);
   while (rs.hasNext()) {
    InternalSheet internelSheet = InternalSheet.createSheet(rs);
    Constructor constructor = HSSFSheet.class.getDeclaredConstructor(HSSFWorkbook.class, InternalSheet.class);
    constructor.setAccessible(true);
    HSSFSheet hssfSheet = (HSSFSheet)constructor.newInstance(wb, internelSheet);
    Field _sheets = HSSFWorkbook.class.getDeclaredField("_sheets"); 
    _sheets.setAccessible(true);
    @SuppressWarnings("unchecked")
    List<HSSFSheet> sheets = (ArrayList<HSSFSheet>)_sheets.get(wb);
    sheets.add(hssfSheet);
   }

   for (int i = 0 ; i < internalWorkbook.getNumNames() ; ++i){
    NameRecord nameRecord = internalWorkbook.getNameRecord(i);
    Constructor constructor = HSSFName.class.getDeclaredConstructor(HSSFWorkbook.class, NameRecord.class, NameCommentRecord.class);
    constructor.setAccessible(true);
    HSSFName name = (HSSFName)constructor.newInstance(wb, nameRecord, internalWorkbook.getNameCommentRecord(nameRecord));
    Field _names = HSSFWorkbook.class.getDeclaredField("names"); 
    _names.setAccessible(true);
    @SuppressWarnings("unchecked")
    List<HSSFName> names = (ArrayList<HSSFName>)_names.get(wb);
    names.add(name);
   }

   //now the workbook is created properly
   System.out.println(wb);

/*
   //getting the data
   DataFormatter formatter = new DataFormatter();
   Sheet sheet = wb.getSheetAt(0);
   for (Row row : sheet) {
    for (Cell cell : row) {
     CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
     System.out.print(cellRef.formatAsString());
     System.out.print(" - ");
     String text = formatter.formatCellValue(cell);
     System.out.println(text);
    }
   }
*/

  }
 }
}