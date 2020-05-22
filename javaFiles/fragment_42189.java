class CellMarginEvent implements PdfPCellEvent {

    Set<Float> xCoordinates = new HashSet<Float>();
    Set<Float> cellHeights = new HashSet<Float>();

    Float left = Float.MAX_VALUE;
    Float right = Float.MIN_VALUE;

    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentBytes) {
        this.xCoordinates.add(rectangle.getLeft());
        this.xCoordinates.add(rectangle.getRight());

        this.cellHeights.add(rectangle.getHeight());

        left = Math.min(left,rectangle.getLeft());
        right = Math.max(right, rectangle.getRight());

    }


    public Set<Float> getxCoordinates() {
        return xCoordinates;
    }

}