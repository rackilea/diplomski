public class MyBorder implements PdfPCellEvent {
    public void cellLayout(PdfPCell cell, Rectangle position,
        PdfContentByte[] canvases) {
        float x1 = position.getLeft() + 2;
        float x2 = position.getRight() - 2;
        float y1 = position.getTop() - 2;
        float y2 = position.getBottom() + 2;
        PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
        canvas.rectangle(x1, y1, x2 - x1, y2 - y1);
        canvas.stroke();
    }
}