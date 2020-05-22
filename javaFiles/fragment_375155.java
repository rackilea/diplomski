import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

class CreateExcelShape {

 public static void main(String[] args) throws Exception {

  try (XSSFWorkbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   XSSFSheet sheet = workbook.createSheet();
   XSSFDrawing drawing = sheet.createDrawingPatriarch();
   XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 1, 25, 3, 32);
   XSSFSimpleShape shape = drawing.createSimpleShape(anchor);

   shape.setShapeType(ShapeTypes.ELLIPSE);
   shape.setFillColor(211, 211, 211);
   shape.setLineStyleColor(0, 0, 0);
   shape.setText("The text inside the shape.");

   shape.setVerticalAlignment(VerticalAlignment.CENTER);
   shape.getTextParagraphs().get(0).setTextAlign(TextAlign.CENTER);

   workbook.write(fileout);
  }

 }
}