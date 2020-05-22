public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    int n = reader.getNumberOfPages();
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.setRotateContents(false);
    // text watermark
    Font f = new Font(FontFamily.HELVETICA, 30);
    Phrase p = new Phrase("My watermark (text)", f);
    // image watermark
    Image img = Image.getInstance(IMG);
    float w = img.getScaledWidth();
    float h = img.getScaledHeight();
    // transparency
    PdfGState gs1 = new PdfGState();
    gs1.setFillOpacity(0.5f);
    // properties
    PdfContentByte over;
    Rectangle pagesize;
    float x, y;
    // loop over every page
    for (int i = 1; i <= n; i++) {
        pagesize = reader.getPageSize(i);
        x = (pagesize.getLeft() + pagesize.getRight()) / 2;
        y = (pagesize.getTop() + pagesize.getBottom()) / 2;
        over = stamper.getOverContent(i);
        over.saveState();
        over.setGState(gs1);
        if (i % 2 == 1)
            ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 0);
        else
            over.addImage(img, w, 0, 0, h, x - (w / 2), y - (h / 2));
        over.restoreState();
    }
    stamper.close();
    reader.close();
}