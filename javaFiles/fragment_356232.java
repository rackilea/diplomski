class CustomUserAgent extends ITextUserAgent 
{
  private final ITextOutputDevice mDevice;

  public CustomUserAgent(ITextOutputDevice dev)
  {
    super(dev);
    mDevice = dev;
  }

  private static final SAXSVGDocumentFactory mFactory = 
    new SAXSVGDocumentFactory(null);

  private ImageResource getSVGImage(String uri)
    throws IOException, BadElementException
  {
    InputStream is = null;

    try
    {
      is = resolveAndOpenStream(uri);
      InputStreamReader isr = new InputStreamReader(is);
      Document doc = mFactory.createSVGDocument(null, isr);
      UserAgent ua = new UserAgentAdapter();
      DocumentLoader loader = new DocumentLoader(ua);
      BridgeContext ctx = new BridgeContext(ua, loader);
      ctx.setDynamicState(BridgeContext.DYNAMIC);
      GVTBuilder builder = new GVTBuilder();
      String not_numbers = "[^0-9.,]";
      float width = 
        Float.parseFloat(doc.getDocumentElement().
                         getAttribute("width").replaceAll(not_numbers, ""));
      float height =
        Float.parseFloat(doc.getDocumentElement().
                         getAttribute("height").replaceAll(not_numbers, ""));
      PdfWriter writer = mDevice.getWriter();
      PdfTemplate templ = PdfTemplate.createTemplate(writer, width, height);
      Graphics2D g2d = templ.createGraphics(width, height);
      GraphicsNode gfx = builder.build(ctx, doc);
      gfx.paint(g2d);
      g2d.dispose();
      Image img = new ImgTemplate(templ);
      img.setAlignment(Image.ALIGN_CENTER);

      SharedContext shctx = getSharedContext();
      float dpi = shctx.getDotsPerPixel();
      if (dpi != 1.0f)
        img.scaleAbsolute(img.getPlainWidth()  * dpi,
                          img.getPlainHeight() * dpi);

      return new ImageResource(uri, new ITextFSImage(img));
    }
    finally
    {
      if (is != null)
        is.close();
    }
  }

  @Override
  public ImageResource getImageResource(String uri)
  {
    if (uri.endsWith(".svg"))
    {
      try
      { return (getSVGImage(uri)); }
      catch(IOException io)
      { throw new RuntimeException(io); }
      catch(BadElementException be)
      { throw new RuntimeException(be); }
    }
    else
      return (super.getImageResource(uri));
  }   
}