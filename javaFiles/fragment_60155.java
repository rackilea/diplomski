/**
 * Highlights text on the document
 */
private void highlightText(Rectangle highlightRectangle) {
    pdfDecoder.getTextLines().addHighlights(new Rectangle[]{highlightRectangle}, false, currentPage);
    pdfDecoder.repaint();
}