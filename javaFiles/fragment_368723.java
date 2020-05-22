import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StackoverflowQuestion51577491 {

    private static final int URL_COLUMN = 2; // Column C
    private static final int PRICE_COLUMN = 3; // Column D

    public static void main(final String[] args) throws Exception {

        // open worksheet with URLs
        Workbook originalWorkbook = Workbook.getWorkbook(new File("O:/original.xls"));
        // create editable copy
        WritableWorkbook workbook = Workbook.createWorkbook(new File("O:/updated.xls"), originalWorkbook);
        // close read-only workbook as it's not needed anymore
        originalWorkbook.close();
        // get first available sheet
        WritableSheet sheet = workbook.getSheet(0);
        // skip title row 0
        int currentRow = 1;
        Cell cell;
        // iterate each cell from column C until we find an empty one
        while (!(cell = sheet.getCell(URL_COLUMN, currentRow)).getType().equals(CellType.EMPTY)) {
            // raed cell contents
            String url = cell.getContents();
            System.out.println("parsing URL: " + url);
            // parse and get the price
            String price = parseUrlWithJsoupAndGetProductPrice(url);
            System.out.println("found price: " + price);
            // create new cell with price
            Label cellWithPrice = new Label(PRICE_COLUMN, currentRow, price);
            sheet.addCell(cellWithPrice);
            // go to next row
            currentRow++;
        }
        // save and close file
        workbook.write();
        workbook.close();
    }

    private static String parseUrlWithJsoupAndGetProductPrice(String url) throws IOException {
        // download page and parse it to Document
        Document doc = Jsoup.connect(url).get();
        // get the price from html
        return doc.select("#priceblock_ourprice").text();
    }
}