float calculateTextWidth(Document document, String text) throws IOException {
    PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, true);
    Paragraph p = new Paragraph(text).setFont(font);
    IRenderer paragraphRenderer = p.createRendererSubTree();
    paragraphRenderer.setParent(document.getRenderer()).layout(new LayoutContext(new LayoutArea(1, new Rectangle(100, 100))));
    return paragraphRenderer.getChildRenderers().get(0).getOccupiedArea().getBBox().getWidth();
}