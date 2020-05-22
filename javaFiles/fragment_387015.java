@Override
public void paint(RenderingContext renderingContext, ITextOutputDevice outputDevice, 
        BlockBox blockBox) {
    PdfContentByte cb = outputDevice.getWriter().getDirectContent();
    float width = (float) (cssWidth / outputDevice.getDotsPerPoint());
    float height = (float) (cssHeight / outputDevice.getDotsPerPoint());

    PdfTemplate template = cb.createTemplate(width, height);
    Graphics2D g2d = template.createGraphics(width, height);
    PrintTranscoder prm = new PrintTranscoder();
    TranscoderInput ti = new TranscoderInput(svg);
    prm.transcode(ti, null);
    PageFormat pg = new PageFormat();
    Paper pp = new Paper();
    pp.setSize(width, height);
    pp.setImageableArea(0, 0, width, height);
    pg.setPaper(pp);
    prm.print(g2d, pg, 0);
    g2d.dispose();

    PageBox page = renderingContext.getPage();
    float x = blockBox.getAbsX() + page.getMarginBorderPadding(renderingContext, CalculatedStyle.LEFT);
    float y = (page.getBottom() - (blockBox.getAbsY() + cssHeight)) + page.getMarginBorderPadding(
            renderingContext, CalculatedStyle.BOTTOM);
    x /= outputDevice.getDotsPerPoint(); 
    y /= outputDevice.getDotsPerPoint();

    cb.addTemplate(template, x, y);
}