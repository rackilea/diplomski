public static void main(String[] args) throws Exception {
    File file = new File(DEST);
    file.getParentFile().mkdirs();
    manipulatePdf(DEST);
}

public static void manipulatePdf(String dest) throws Exception {
    PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
    Document doc = new Document(pdfDoc);

    Table table = new Table(8);
    for (int i = 0; i < 16; i++) {
        Paragraph para = new Paragraph("hi");
        // now you can use methods like:
        // para.setFont()
        // para.setFontColor()
        // para.setFontSize()
        table.addCell(para);
    }
    doc.add(table);

    doc.close();
}