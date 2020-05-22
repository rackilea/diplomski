// PDFBox 2.0.8 require org.apache.pdfbox.io.RandomAccessRead
// import org.apache.pdfbox.io.RandomAccessFile;

public class PDFReader{
    public static void main(String args[]) throws IOException {
        PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        File file = new File("C:/my.pdf");
        PDFParser parser = new PDFParser(new FileInputStream(file));
        parser.parse();
        try (COSDocument cosDoc = parser.getDocument()) {
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(5);
            String parsedText = pdfStripper.getText(pdDoc);
            System.out.println(parsedText);
        }
    }
}