try (ByteArrayOutputStream byteData = new ByteArrayOutputStream()) {

    Document document = new Document(PageSize.A4);

    PdfWriter writer = PdfWriter.getInstance(document, byteData);           
    writer.setInitialLeading(12.5f);

    document.open();

    CSSResolver cssResolver = new StyleAttrCSSResolver();
    CssFile cssFile = XMLWorkerHelper.getCSS(new FileInputStream("itext2\\css\\bootstrap.min.css"));
    cssResolver.addCss(cssFile);

    HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
    htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());

    PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
    CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

    XMLWorker worker = new XMLWorker(css, true);
    XMLParser p = new XMLParser(worker);

    String fileContent = PdfTest.readFile("itext2\\template.html");

    p.parse(new StringReader(fileContent));

    document.close();

    PdfReader reader = new PdfReader(byteData.toByteArray());
    Document document1 = new Document();
    File resultFile = new File("result.pdf");
    PdfSmartCopy pdfCopy = new PdfSmartCopy(document1, new FileOutputStream(resultFile));
    document1.open();
    PdfImportedPage page;
    for (int pageNumber = 1; pageNumber <= reader.getNumberOfPages(); pageNumber++) {
        page = pdfCopy.getImportedPage(reader, pageNumber);
        pdfCopy.addPage(page);
    }

    document1.close();
    byteData.close();
} catch (Exception e) {
    e.printStackTrace();
}