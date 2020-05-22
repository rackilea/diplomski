private void addFooterImproved(PdfWriter writer) {
    PdfPTable footer = new PdfPTable(2);
    try {
        // set defaults
        footer.setWidths(new int[]{2, 20});
        footer.setWidthPercentage(50);

        footer.setTotalWidth(527);
        footer.setLockedWidth(true);
        footer.getDefaultCell().setFixedHeight(30);
        footer.getDefaultCell().setBorder(Rectangle.TOP);
        footer.getDefaultCell().setBorderColor(BaseColor.RED);
        footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
        footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));

        // add placeholder for total page count
        PdfPCell totalPageCount = new PdfPCell(total);
        totalPageCount.setBorder(Rectangle.TOP);
        totalPageCount.setBorderColor(BaseColor.GREEN);
        footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.addCell(totalPageCount);

        // write page
        PdfContentByte canvas = writer.getDirectContent();
        canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
        footer.writeSelectedRows(0, -1, 34, 20, canvas);
        canvas.endMarkedContentSequence();
    } catch(DocumentException de) {
        throw new ExceptionConverter(de);
    }
}