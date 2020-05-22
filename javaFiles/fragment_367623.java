package q46617008;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApacheExample
{

    public void build( WorksheetExample w ) throws Exception
    {

        Workbook wb = new XSSFWorkbook( );

        Sheet s = wb.createSheet( );
        // If you need to name it:
        // String name = WorkbookUtil.createSafeSheetName( "the name!" );
        // Sheet s = wb.createSheet( name );

        Row titleRow = s.createRow( 0 );
        Cell titleCell = titleRow.createCell( 0 );
        titleCell.setCellValue( "Alphabets List" );

        Row r;
        Cell c;
        int i = 1;
        Iterator< String > alphabetsIterator = WorksheetExample.alphabets.iterator( );
        while ( alphabetsIterator.hasNext( ) )
        {
            String alphabet = alphabetsIterator.next( );
            r = s.createRow( i );
            c = r.createCell( 0 );
            c.setCellValue( alphabet );
            i++;
        }

        // Skip one line to start books list title.
        // If you need this in another sheet, just create it:
        // s = wb.createSheet();
        i++;
        titleRow = s.createRow( i );
        titleCell = titleRow.createCell( 0 );
        titleCell.setCellValue( "Books List" );

        // Skip one line to start books list.
        i++;
        Iterator< Entry< String, String > > booksIterator = WorksheetExample.books.entrySet( ).iterator( );
        while ( booksIterator.hasNext( ) )
        {
            Entry< String, String > book = booksIterator.next( );
            r = s.createRow( i );
            c = r.createCell( 0 );
            c.setCellValue( book.getKey( ) + ". " + book.getValue( ) );
            i++;
        }

        OutputStream fileOut = Files.newOutputStream( w.file, StandardOpenOption.CREATE );
        wb.write( fileOut );
        fileOut.close( );

        wb.close( );
    }

}