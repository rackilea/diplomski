public void createPdf(String file) throws IOException, DocumentException {
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
    // step 3
    document.open();
    // step 4
    // Styles
    CSSResolver cssResolver = new StyleAttrCSSResolver();
    XMLWorkerFontProvider fontProvider = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
    fontProvider.register("resources/fonts/NotoNaskhArabic-Regular.ttf");
    CssAppliers cssAppliers = new CssAppliersImpl(fontProvider);
    // HTML
    HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
    // Pipelines
    ElementList elements = new ElementList();
    ElementHandlerPipeline pdf = new ElementHandlerPipeline(elements, null);
    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

    // XML Worker
    XMLWorker worker = new XMLWorker(css, true);
    XMLParser p = new XMLParser(worker);
    p.parse(new FileInputStream(HTML), Charset.forName("UTF-8"));

    PdfPTable table = new PdfPTable(1);
    PdfPCell cell = new PdfPCell();
    cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
    for (Element e : elements) {
        cell.addElement(e);
    }
    table.addCell(cell);
    document.add(table);
    // step 5
    document.close();
}