/**
 * Transforms Component coordinates to page coordinates, correcting for 
 * scaling and panning.
 * 
 * @param x Component x-coordinate
 * @param y Component y-coordinate
 * @return Point on the PDF page
 */
private Point getPageCoordinates(int x, int y) {
    float scaling = pdfDecoder.getScaling();
    int x_offset = ((pdfDecoder.getWidth() - pdfDecoder.getPDFWidth()) / 2); 
    int y_offset = pdfDecoder.getPDFHeight();
    int correctedX = (int)((x - x_offset + viewportOffset.x) / scaling);
    int correctedY = (int)((y_offset - (y + viewportOffset.y))  / scaling);
    return new Point(correctedX, correctedY);
}