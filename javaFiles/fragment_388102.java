public class XmlToCsv {

    @Inject
    DocumentBuilderFactory factory;

    @Inject
    StreamSource stylesource;

    @Inject
    TransformerFactory transformerFactory;

    public void xmlToCsv(String sourceXlsFile, String sourceCsvFile, String sourceXmlFile) throws Exception {

        //define the files
        File stylesheet = new File(sourceXlsFile);
        File xmlSource = new File(sourceXmlFile);

        //create the DocumentBuilder to parse the XML file
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);

        //input the stylesheet to transform the XML to
        StreamSource stylesource = new StreamSource(stylesheet);
        Transformer transformer = transformerFactory.newInstance().newTransformer(stylesource);

        //write a new output file using the stylesheet format
        Source source = new DOMSource(document);
        Result outputTarget = new StreamResult(new File(sourceCsvFile));
        transformer.transform(source, outputTarget);

    }
}