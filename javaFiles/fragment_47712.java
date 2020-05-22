@Test
public void unicodeRendering() throws Exception {
    // create a sample pptx
    XMLSlideShow ss = createSamplePPT();
    Dimension pgsize = ss.getPageSize();

    // set the font
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    for (String s : new String[]{"GEInspRg.ttf","mona.ttf"}) {
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(s));
        ge.registerFont(font);
    }
    Map<String,String> fallbackMap = new HashMap<String,String>();
    fallbackMap.put("GE Inspira", "Mona");

    // render it
    double zoom = 2; // magnify it by 2
    AffineTransform at = new AffineTransform();
    at.setToScale(zoom, zoom);

    BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width * zoom),
            (int)Math.ceil(pgsize.height * zoom), BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = img.createGraphics();
    graphics.setRenderingHint(Drawable.FONT_FALLBACK, fallbackMap);
    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);

    graphics.setTransform(at);
    graphics.setPaint(Color.white);
    graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
    ss.getSlides().get(0).draw(graphics);

    javax.imageio.ImageIO.write(img, "png", new File("unicodeppt.png"));

    ss.close();
}

private XMLSlideShow createSamplePPT() {
    XMLSlideShow ss = new XMLSlideShow();
    Dimension pgsize = ss.getPageSize();

    XSLFSlide slide = ss.createSlide();
    XSLFTextBox tb = slide.createTextBox();
    // tb.setShapeType(XSLFShapeType.HEART);
    int shapeSize = 150;
    tb.setAnchor(new Rectangle((int)(pgsize.getWidth() / 2 - shapeSize / 2),
            (int)(pgsize.getHeight() / 2 - shapeSize / 2), shapeSize, shapeSize));
    tb.setLineWidth(2);
    tb.setLineColor(Color.BLACK);
    XSLFTextParagraph par = tb.addNewTextParagraph();
    tb.setVerticalAlignment(VerticalAlignment.DISTRIBUTED);
    par.setTextAlign(TextAlign.CENTER);
    XSLFTextRun run = par.addNewTextRun();
    run.setText("unicode ->\u30B4\u30DF\u7BB1<-");
    run.setFontFamily("GE Inspira");
    run.setFontSize(12.0);
    return ss;
}