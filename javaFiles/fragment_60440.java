public ElementList parseHtml(String html, String css) throws IOException {
    // CSS
    CSSResolver cssResolver = new StyleAttrCSSResolver();
    CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(css.getBytes()));
    cssResolver.addCss(cssFile);

    // HTML
    CssAppliers cssAppliers = new CssAppliersImpl(FontFactory.getFontImp());
    HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
    htmlContext.autoBookmark(false);

    // Pipelines
    ElementList elements = new ElementList();
    ElementHandlerPipeline end = new ElementHandlerPipeline(elements, null);
    HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, end);
    CssResolverPipeline cssPipeline = new CssResolverPipeline(cssResolver, htmlPipeline);

    // XML Worker
    XMLWorker worker = new XMLWorker(cssPipeline, true);
    XMLParser p = new XMLParser(worker);
    p.parse(new ByteArrayInputStream(html.getBytes()));

    return elements;
}