public static void main(String[] args) throws DocumentException, FileNotFoundException, IOException {
    String TARGET = "temp.pdf";
    Document document = new Document(PageSize.A4);
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(TARGET));
    document.open();


    PdfPTable table = new PdfPTable(7);         

    for (int i = 0; i < 700; i++) {
        Phrase p = new Phrase("some text");
        PdfPCell cell = new PdfPCell();
        cell.addElement(p);
        table.addCell(cell);            
    }

    table.setTotalWidth(PageSize.A4.getWidth());
    table.setLockedWidth(true);
    PdfContentByte canvas = writer.getDirectContent();
    PdfTemplate template = canvas.createTemplate(table.getTotalWidth(), table.getTotalHeight());
    table.writeSelectedRows(0, -1, 0, table.getTotalHeight(), template);
    Image img = Image.getInstance(template);
    img.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
    img.setAbsolutePosition(0, (PageSize.A4.getHeight() - table.getTotalHeight()) / 2);
    document.add(img);
    document.close();
}