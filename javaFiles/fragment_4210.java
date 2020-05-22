void dropSaturation(PdfStamper pdfStamper) {
    PdfGState gstate = new PdfGState();
    gstate.setBlendMode(PdfName.SATURATION);
    PdfReader pdfReader = pdfStamper.getReader();
    for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
        PdfContentByte canvas = pdfStamper.getOverContent(i);
        canvas.setGState(gstate);
        Rectangle mediaBox = pdfReader.getPageSize(i);
        canvas.setColorFill(BaseColor.BLACK);
        canvas.rectangle(mediaBox.getLeft(), mediaBox.getBottom(), mediaBox.getWidth(), mediaBox.getHeight());
        canvas.fill();
        canvas = pdfStamper.getUnderContent(i);
        canvas.setColorFill(BaseColor.WHITE);
        canvas.rectangle(mediaBox.getLeft(), mediaBox.getBottom(), mediaBox.getWidth(), mediaBox.getHeight());
        canvas.fill();
    }
}