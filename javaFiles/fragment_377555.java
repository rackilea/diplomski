import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class MyPDF {
    public static void main(String[] args) {

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(
                    "Test.pdf")));
            document.open();
            String content = "pdf data...";
            Paragraph paragraph = new Paragraph(content);
            document.add(paragraph);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}