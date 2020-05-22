public static final String FONT = "resources/fonts/NotoSansCJKsc-Regular.otf";
public static final String TEXT = "These are the protagonists in 'Hero', a movie by Zhang Yimou:\n"
    + "\u7121\u540d (Nameless), \u6b98\u528d (Broken Sword), "
    + "\u98db\u96ea (Flying Snow), \u5982\u6708 (Moon), "
    + "\u79e6\u738b (the King), and \u9577\u7a7a (Sky).";
public static final String CHINESE = "\u5341\u950a\u57cb\u4f0f";
public static final String JAPANESE = "\u8ab0\u3082\u77e5\u3089\u306a\u3044";
public static final String KOREAN = "\ube48\uc9d1";

public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(DEST));
    document.open();
    Font font = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    Paragraph p = new Paragraph(TEXT, font);
    document.add(p);
    document.add(new Paragraph(CHINESE, font));
    document.add(new Paragraph(JAPANESE, font));
    document.add(new Paragraph(KOREAN, font));
    document.close();
}