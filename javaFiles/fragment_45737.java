import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class HelloWorld {
        public static void main(String[] args) {
                Document document = new Document();
                try {
                        PdfWriter.getInstance(document,
                                        new FileOutputStream("HelloWorld.pdf"));
                        document.open();
                        String text = "";
                        for (int i = 0; i < 10000; i++) {
                                text += "test";
                        }
                        document.add(new Paragraph(text));
                } catch (DocumentException e) {
                        System.err.println(e.getMessage());
                } catch (IOException ex) {
                        System.err.println(ex.getMessage());
                }
                document.close();
        }
}