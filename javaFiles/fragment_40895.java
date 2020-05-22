class WatermarkedCell implements PdfPCellEvent {
    String watermark;

    public WatermarkedCell(String watermark) {
        this.watermark = watermark;
    }

    public void cellLayout(PdfPCell cell, Rectangle position,
        PdfContentByte[] canvases) {
        PdfContentByte canvas = canvases[PdfPTable.TEXTCANVAS];
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER,
            new Phrase(watermark, FONT),
            (position.getLeft() + position.getRight()) / 2,
            (position.getBottom() + position.getTop()) / 2, 30);
    }
}