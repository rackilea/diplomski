public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document(PageSize.A4.rotate());
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    PdfPTable tbl = new PdfPTable(new float[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
    //loop through 100 rows
    for (int r = 1; r <= 100; r++) {
        for (int c = 1; c <= 24; c++) {
            tbl.addCell(String.format("r%sc%s", r, c));
        }
    }
    PdfContentByte canvas = writer.getDirectContent();
    tbl.setTotalWidth(1500);//set table width
    float top = document.top() - document.topMargin() - 30;
    float yPos = top;
    int start = 0;
    int stop = 0;
    for (int i = 0; i < 100; i++) {
        yPos -= tbl.getRowHeight(i);
        if (yPos < 0) {
            stop = --i;
            tbl.writeSelectedRows(0, 12, start, stop, document.leftMargin(), top, canvas);
            document.newPage();
            tbl.writeSelectedRows(12, -1, start, stop, 5, top, canvas);
            start = stop;
            document.newPage();
            yPos = top;
        }
    }
    tbl.writeSelectedRows(0, 12, stop, -1, document.leftMargin(), top, canvas);
    document.newPage();
    tbl.writeSelectedRows(12, -1, stop, -1, 5, top, canvas);
    document.close();
}