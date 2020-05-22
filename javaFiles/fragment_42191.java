Set<Float> xCoordinates = cellMarginEvent.getxCoordinates();

    //Draw the column lines
    PdfContentByte canvas = writer.getDirectContent();
    for (Float x : xCoordinates) {
        canvas.moveTo(x, top);
        canvas.lineTo(x, 0 + document.bottomMargin());

        canvas.closePathStroke();
    }
    Set<Float> cellHeights = cellMarginEvent.cellHeights;
    Float cellHeight = (Float)cellHeights.toArray()[0];
    float currentPosition = writer.getVerticalPosition(false);
    //Draw the row lines
    while (currentPosition >= document.bottomMargin()) {
        canvas.moveTo(cellMarginEvent.left,currentPosition);
        canvas.lineTo(cellMarginEvent.right,currentPosition);
        canvas.closePathStroke();
        currentPosition -= cellHeight;
    }