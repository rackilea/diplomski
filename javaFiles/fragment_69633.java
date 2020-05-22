import com.itextpdf.text.html.simpleparser.HTMLWorker;
//...
try {
    String k = "<html><body> This is my Project </body></html>";
    OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));
    Document document = new Document();
    PdfWriter.getInstance(document, file);
    document.open();
    HTMLWorker htmlWorker = new HTMLWorker(document);
    htmlWorker.parse(new StringReader(k));
    document.close();
    file.close();
} catch (Exception e) {
    e.printStackTrace();
}