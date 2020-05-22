import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POITest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        File file = new File("F:\\test.xlsx");

        int sheets = 0;
        try {
            Workbook book = WorkbookFactory.create(file);
            sheets = book.getNumberOfSheets();
            System.out.println(sheets);
            book.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStream file2 = new FileInputStream("F:\\test.xlsx");
            Workbook book = new XSSFWorkbook(file2);
            sheets = book.getNumberOfSheets();
            System.out.println(sheets);
            book.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}