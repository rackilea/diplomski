public void createPdfFromHtml(String htmlSource, String pdfDest, String resoureLoc) throws IOException, InterruptedException {
    File pdf = new File(pdfDest);
    pdf.getParentFile().mkdirs();

    //convertToElements takes the string containing the HTML as input
    byte[] bytes = StreamUtil.inputStreamToArray(new FileInputStream(htmlSource));
    String html = new String(bytes);


    PdfWriter writer = new PdfWriter(pdfDest);
    PdfDocument pdfDoc = new PdfDocument(writer);

    Document doc = new Document(pdfDoc,pageSize);


    // Create the page size modifying event handler
    PageSize pageSize = PageSize.A4;
    pageSize = pageSize.rotate();//Start in landscape
    int differentPageSizeInterval = 5;
    PageSizeModifier pageSizeModifier = new PageSizeModifier(doc, differentPageSizeInterval, pageSize);
    //Register it to the pdfDocument and set it to trigger at the start of a page
    pdfDoc.addEventHandler(PdfDocumentEvent.START_PAGE,pageSizeModifier);
    ConverterProperties converterProperties = new ConverterProperties();
    converterProperties.setBaseUri(resoureLoc);
    //Convert the html to elements
    try {
        //parse and return the top level elements of the <body>
        List<IElement> elements = HtmlConverter.convertToElements(html, converterProperties);
        for (IElement ele : elements) {
            //Add the elements to the layout document
            doc.add((BlockElement) ele);
        }
        doc.close();
    } catch (PdfException e) {
        System.out.println(e);
        e.printStackTrace();
    }
}

protected class PageSizeModifier implements IEventHandler {

    Document doc;
    int interval;
    int counter;
    PageSize pageSize;

    public PageSizeModifier(Document doc, int interval,PageSize pageSize) {
        this.doc = doc; //A reference to the layout document must be kept so we can change the margins on the fly
        this.interval = interval;
        this.counter = 1;
        this.pageSize = pageSize;//Start out in landscape
    }
    @Override
    public void handleEvent(Event event) {
        if(counter == interval){
            //Rotate
            pageSize = pageSize.rotate();
            //For the rendering framework, change the default page size
            doc.getPdfDocument().setDefaultPageSize(pageSize);

            //because the page was already created, we need to update the various boxes determining the pagesize
            //By default, only the trim and mediabox will be present
            ((PdfDocumentEvent) event).getPage().setMediaBox(pageSize);
            ((PdfDocumentEvent) event).getPage().setTrimBox(pageSize);

            //Reset the counter
            counter = 1;

        }else{
            counter++;
        }

    }