public static final String CSS = "th { border-top: 5px solid green; } "
    + "td { font-size: 10pt; border-color: gray; border: 3px}";
public static final String HTML = "<html><body><table  class='table-bordered'>"
    + "<thead><tr><th>Customer Name</th><th>Customer's Address</th> </tr></thead>"
    + "<tbody><tr><td> XYZ </td><td> Bhubaneswar </td></tr>"
    + "<tr><td> MNP </td><td> Cuttack </td></tr></tbody>"
    + "</table></body></html>";

/**
 * @param file
 * @throws IOException
 * @throws DocumentException
 */
public void createPdf(String file) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
    document.open();


    CSSResolver cssResolver = new StyleAttrCSSResolver();
    CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(CSS.getBytes()));
    cssResolver.addCss(cssFile);

    // HTML
    HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

    // Pipelines
    PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

    // XML Worker
    XMLWorker worker = new XMLWorker(css, true);
    XMLParser p = new XMLParser(worker);
    p.parse(new ByteArrayInputStream(HTML.getBytes()));
    document.close();
}