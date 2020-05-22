/**
 * Scans for all the words located with in a box the width of the page and 
 * 40 points high, centered at the supplied point.
 * 
 * @param p Point to centre the scan box around
 * @return  A List of words within the scan box
 * @throws PdfException
 */
private List<String> scanForWords(Point p) throws PdfException {
    List<String> result = Collections.emptyList();
    if (pdfDecoder.getlastPageDecoded() > 0) {
        PdfGroupingAlgorithms currentGrouping = pdfDecoder.getGroupingObject();
        PdfPageData currentPageData = pdfDecoder.getPdfPageData();
        int x1 = currentPageData.getMediaBoxX(currentPage);
        int x2 = currentPageData.getMediaBoxWidth(currentPage) + x1;
        int y1 = p.y + 20;
        int y2 = p.y - 20;
        result = currentGrouping.extractTextAsWordlist(x1, y1, x2, y2, currentPage, true, "");
    }
    return result;
}