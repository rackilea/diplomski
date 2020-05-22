import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.util.IOUtils;

class CreateXSSFCommentWithPicture {

 public static void main(String[] args) throws Exception {

  try (XSSFWorkbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   // First we create a default XSSFComment:

   XSSFCreationHelper factory = workbook.getCreationHelper();

   XSSFSheet sheet = workbook.createSheet("Sheet");
   XSSFRow row = sheet.createRow(3);
   XSSFCell cell = row.createCell(5);
   cell.setCellValue("F4");

   XSSFDrawing drawing = sheet.createDrawingPatriarch();

   XSSFClientAnchor anchor = factory.createClientAnchor();
   anchor.setCol1(cell.getColumnIndex());
   anchor.setCol2(cell.getColumnIndex()+2);
   anchor.setRow1(row.getRowNum());
   anchor.setRow2(row.getRowNum()+5);

   XSSFComment comment = drawing.createCellComment(anchor);
   XSSFRichTextString str = factory.createRichTextString("Hello, World!");
   comment.setString(str);
   comment.setAuthor("Apache POI");

   // assign the comment to the cell
   cell.setCellComment(comment);


   // Now we put the image as fill of the comment's shape:

   // add picture data to this workbook
   InputStream is = new FileInputStream("samplePict.jpeg");
   byte[] bytes = IOUtils.toByteArray(is);
   int pictureIdx = workbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_JPEG);
   is.close();
   // get picture data
   XSSFPictureData pictureData = workbook.getAllPictures().get(pictureIdx);

   // get VML drawing
   java.lang.reflect.Method getVMLDrawing = XSSFSheet.class.getDeclaredMethod("getVMLDrawing", boolean.class);
   getVMLDrawing.setAccessible(true);
   XSSFVMLDrawing vml = (XSSFVMLDrawing)getVMLDrawing.invoke(sheet, true);

   // set relation to the picture data in VML drawing
   org.apache.poi.ooxml.POIXMLDocumentPart.RelationPart rp = vml.addRelation(null, XSSFRelation.IMAGES, pictureData);

   // get comment shape
   com.microsoft.schemas.vml.CTShape commentShape = vml.findCommentShape(cell.getRow().getRowNum(), cell.getColumnIndex());
   // get fill of comment shape
   com.microsoft.schemas.vml.CTFill fill = commentShape.getFillArray(0);
   // already set color needs to be color2 now
   fill.setColor2(fill.getColor());
   fill.unsetColor();
   // set relation Id of the picture
   fill.setRelid(rp.getRelationship().getId());
   // set some other properties
   fill.setTitle("samplePict");
   fill.setRecolor(com.microsoft.schemas.vml.STTrueFalse.T);
   fill.setRotate(com.microsoft.schemas.vml.STTrueFalse.T);
   fill.setType(com.microsoft.schemas.vml.STFillType.FRAME);

   workbook.write(fileout);
  }

 }
}