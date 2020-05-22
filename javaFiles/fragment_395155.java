import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.common.*;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

class GetDataFromExcel {

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

  Sheet sheet = workbook.getSheetAt(0);

  int headerRowNum = sheet.getFirstRowNum();

  // collecting the column headers
  TreeMap<Integer, String> colHeaders = new TreeMap<Integer, String>();
  Row row = sheet.getRow(headerRowNum);
  for (Cell cell : row) {
   int colIdx = cell.getColumnIndex();
   String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
   colHeaders.put(colIdx, value);
  }

System.out.println(colHeaders);

  // collecting the data records
  List<List<String>> dataRecords = new ArrayList<List<String>>();
  for (int r = headerRowNum + 1; r <= sheet.getLastRowNum(); r++) {
   row = sheet.getRow(r); if (row == null) row = sheet.createRow(r);
   List<String> values = new ArrayList<String>();
   for (Map.Entry<Integer, String> entry : colHeaders.entrySet()) {
    int colIdx = entry.getKey();
    Cell cell = row.getCell(colIdx); if (cell == null) cell = row.createCell(colIdx);
    String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
    values.add(value);
   }
   dataRecords.add(values);
  }

System.out.println(dataRecords);

  workbook.close();

  // create PDF
  final PDFont font = PDType1Font.HELVETICA;
  final float fontSize = 12.0f;
  final float lineHeight = fontSize * 1.42857f;
  PDPage page = new PDPage(); //U.S. Letter, 8.5" x 11"
  final PDRectangle artBox = page.getArtBox();
  final float artBoxHeight = artBox.getHeight();
  final float artBoxWidth = artBox.getWidth();
  final float leftMargin = artBoxWidth / 8.5f; // 1"
  final float topMargin = artBoxHeight / 11.0f; // 1"
  final float bottomMargin = artBoxHeight / 11.0f; // 1"

  PDDocument doc = new PDDocument();

  doc.addPage(page);
  PDPageContentStream contents = new PDPageContentStream(doc, page);
  contents.beginText();
  contents.setFont(font, fontSize);
  float currentLinePos = artBoxHeight-topMargin;
  contents.newLineAtOffset(leftMargin, currentLinePos);

  for (List<String> dataRecord : dataRecords) {
   Integer colIdx = colHeaders.firstKey();
   for (String value : dataRecord) {
    if (colIdx != null) {
     String header = colHeaders.get(colIdx);
     if (currentLinePos <= bottomMargin) {
      contents.endText();
      contents.close();
      page = new PDPage();
      doc.addPage(page);
      contents = new PDPageContentStream(doc, page);
      contents.beginText();
      contents.setFont(font, fontSize);
      currentLinePos = artBoxHeight-topMargin;
      contents.newLineAtOffset(leftMargin, currentLinePos);
     }
     contents.showText(header + ": " + value);
     contents.newLineAtOffset(0, -lineHeight);
     currentLinePos -= lineHeight;
    }
    colIdx = colHeaders.higherKey(colIdx);
   }
   contents.newLineAtOffset(0, -lineHeight);
   currentLinePos -= lineHeight;   
  }

  contents.endText();
  contents.close();

  doc.save("ExcelExample.pdf");
  doc.close();

 }
}