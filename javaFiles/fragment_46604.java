public class SquareBullet {
    public static void main(String[] args) throws IOException, DocumentException, XMPException {
        Document document = new Document();
        PdfAWriter writer = PdfAWriter.getInstance(document, new FileOutputStream("list.pdf"), PdfAConformanceLevel.PDF_A_1A);
        writer.setViewerPreferences(PdfAWriter.PageModeUseOutlines);
        writer.setRunDirection(PdfAWriter.RUN_DIRECTION_LTR);
        writer.setTagged(PdfAWriter.markAll);
        writer.createXmpMetadata();
        XmpWriter xmp = writer.getXmpWriter();

        DublinCoreProperties.addSubject(xmp.getXmpMeta(), "Subject");
        DublinCoreProperties.setTitle(xmp.getXmpMeta(), "Title", "en_US", "en_US");
        DublinCoreProperties.setDescription(xmp.getXmpMeta(), "Description", "en_US", "en_US");
        PdfProperties.setKeywords(xmp.getXmpMeta(), "Keywords");
        PdfProperties.setVersion(xmp.getXmpMeta(), "1.4");
        document.addLanguage("en_US");
        document.open();
        Font font1 = FontFactory.getFont("ROsanswebtextregular.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED, 12);
        ICC_Profile icc = ICC_Profile.getInstance(new FileInputStream("sRGB Color Space Profile.icm"));
        writer.setOutputIntents("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1", icc);

        Chunk c = new Chunk("Google", font1);
        PdfAction action = new PdfAction("https://google.com");

        PdfAnnotation annotation = PdfAnnotation.createLink(
                writer, new Rectangle(0 ,0), PdfName.HIGHLIGHT,
                action);
        annotation.put(PdfName.CONTENTS, PdfName.TEXT);
        annotation.setBorderStyle(new PdfBorderDictionary(0, PdfBorderDictionary.STYLE_BEVELED));
        c.setAnnotation(annotation);
        document.add(c);
        document.close();
    }
}