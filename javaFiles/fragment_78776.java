void drawBoundingBox(PDDocument pdDocument, PDPage pdPage) throws IOException {
    BoundingBoxFinder boxFinder = new BoundingBoxFinder(pdPage);
    boxFinder.processPage(pdPage);
    Rectangle2D box = boxFinder.getBoundingBox();
    if (box != null) {
        try (   PDPageContentStream canvas = new PDPageContentStream(pdDocument, pdPage, AppendMode.APPEND, true, true)) {
            canvas.setStrokingColor(Color.magenta);
            canvas.addRect((float)box.getMinX(), (float)box.getMinY(), (float)box.getWidth(), (float)box.getHeight());
            canvas.stroke();
        }
    }
}