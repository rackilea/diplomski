/**
 * Highlights the word at the given point.
 * 
 * @param p Point where word is located
 */
private void highlightWordAtPoint(Point p) {
    try {
        Rectangle wordBounds = findWordBoundsAtPoint(p, parseWordBounds(scanForWords(p)));
        if (wordBounds != null) {
            highlightText(contractHighlight(wordBounds));
        }
    } catch (PdfException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}