import com.itextpdf.tool.xml.XMLWorkerHelper;
//...
try {
    String k = "<html><body> This is my Project </body></html>";
    OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, file);
    document.open();
    InputStream is = new ByteArrayInputStream(k.getBytes());
    XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
    document.close();
    file.close();
} catch (Exception e) {
    e.printStackTrace();
}