public class Test1 {
    public static void main(String args[]) throws Exception{
        PdfReader reader = new PdfReader(new RandomAccessFileOrArray("C:\\test.pdf"), null);
        Document doc = new Document(reader.getPageSize(1));
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\result.pdf"));
        Font link = FontFactory.getFont("Arial", 12, Font.UNDERLINE);
        doc.open();
        PdfContentByte pdfContentByte = writer.getDirectContent();
        Anchor topAnchor = null;
        PdfImportedPage page = null;
        for (int i = 1; i < reader.getNumberOfPages(); i++)
        {
            if (i == 1)
            {
                Anchor click = new Anchor("Click to go to Target");
                click.setReference("#target");
                Paragraph p1 = new Paragraph();
                p1.add(click);
                doc.add(p1);
                page = writer.getImportedPage(reader, i);
                doc.newPage();
                pdfContentByte.addTemplate(page, 0, 0);
            }
            else
            {
                if (i == 5)
                {
                    Anchor target = new Anchor("My targer");
                    target.setName("target");
                    Paragraph p3 = new Paragraph();
                    p3.add(target);
                    doc.add(p3);
                }
                page = writer.getImportedPage(reader, i);
                doc.newPage();
                pdfContentByte.addTemplate(page, 0, 0);
            }
        }
        doc.close();
    }
}