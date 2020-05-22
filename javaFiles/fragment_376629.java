import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
public class imagesPDF
{     
    public static void main(String arg[])throws Exception
    {                  
        Document document=new Document();
        PdfWriter.getInstance(document,new FileOutputStream("YourPDFHere.pdf"));
        document.open();
        Image image = Image.getInstance ("yourImageHere.jpg");
        document.add(new Paragraph("Your Heading for the Image Goes Here"));
        document.add(image);               
        document.close();
   }
}