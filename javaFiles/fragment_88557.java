import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.hssf.record.*;
import org.apache.poi.ddf.*;

import java.util.List;
import java.util.ArrayList;

class ShapeNameTestHSSF {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("workbook1.xls");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   EscherAggregate escherAggregate = ((HSSFSheet)sheet).getDrawingEscherAggregate();

   EscherContainerRecord escherContainer = escherAggregate.getEscherContainer().getChildContainers().get(0); 
   //throws java.lang.NullPointerException if no Container present

   List<EscherRecord> escherOptRecords = new ArrayList<EscherRecord>();

   escherContainer.getRecordsById(EscherOptRecord.RECORD_ID, escherOptRecords);

   for (EscherRecord escherOptRecord : escherOptRecords) {
    for (EscherProperty escherProperty : ((EscherOptRecord)escherOptRecord).getEscherProperties()) {
     System.out.println(escherProperty.getName());
     if (escherProperty.isComplex()) {
      System.out.println(new String(((EscherComplexProperty)escherProperty).getComplexData(), "UTF-16LE"));
     } else {
      if (escherProperty.isBlipId()) System.out.print("BlipId = ImageId = ");
      System.out.println(((EscherSimpleProperty)escherProperty).getPropertyValue());
     }
     System.out.println("=============================");
    }
    System.out.println(":::::::::::::::::::::::::::::");
   }


   FileOutputStream fileOut = new FileOutputStream("workbook1.xls");
   wb.write(fileOut);
   fileOut.flush();
   fileOut.close();

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}