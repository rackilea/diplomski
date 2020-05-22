public class FopTest {

    public static void main(String[] args) throws Exception {

        // the XSL FO file
        StreamSource xsltFile = new StreamSource(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("template.xsl"));
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(
                Thread.currentThread().getContextClassLoader().getResourceAsStream("employees.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = new FopFactoryBuilder(new File(".").toURI()).build();

        RendererFactory rendererFactory = fopFactory.getRendererFactory();
        rendererFactory.addDocumentHandlerMaker(new CustomPDFDocumentHandlerMaker());

        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        // Setup output
        OutputStream out;
        out = new java.io.FileOutputStream("employee.pdf");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltFile);

            // Resulting SAX events (the generated FO) must be piped through to
            // FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }

    }

}