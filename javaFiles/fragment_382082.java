public static final String FONT = "resources/fonts/Cardo-Regular.ttf";
public static final String TEXT = "The Cardo family of fonts supports this character: \u2609";

public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Font f = new Font(bf, 12);
    Paragraph p = new Paragraph(TEXT, f);
    document.add(p);
    document.close();
}