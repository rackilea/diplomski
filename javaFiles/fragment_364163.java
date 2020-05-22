import java.io.File;
import org.apache.poi.ss.usermodel.*;

public static Sheet getExcelSheet(String fileName, int sheetIndex) throws IOException {
   File file = new File(fileName);
   Workbook workbook = WorkbookFactory.create(file);
   return workbook.getSheetAt(sheetIndex);
}