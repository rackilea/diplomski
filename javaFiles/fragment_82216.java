public class LocalSchemaLSResourceResolver implements LSResourceResolver{

    protected final Log logger = LogFactory.getLog(getClass());

    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {

        LSInput input = new DOMInputImpl();
        try {
            FileInputStream fis = new FileInputStream(new File("classpath:xsd/" + systemId));

            input.setByteStream(fis);
            return input;
        } catch (FileNotFoundException ex) {
            logger.error("File Not found", ex);
            return null;
        }

    }
}