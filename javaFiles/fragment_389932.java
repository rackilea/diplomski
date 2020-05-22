@Provider
@Consumes(MediaType.APPLICATION_XML)
public class XmlValidationReader implements MessageBodyReader<Category> {

    protected Providers providers;
    protected ServletContext servletContext;
    private final String xsdFileName = "/Category.xsd";
    private Schema schema;

    public XmlValidationReader(@Context Providers providers,
            @Context ServletContext servletContext) {
        this.providers = providers;
        this.servletContext = servletContext;

        try {
            SchemaFactory sf = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsd = new File(servletContext.getRealPath(xsdFileName));
            schema = sf.newSchema(xsd);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to create XSD validation schema", e);
        }
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        ...
    }


    @Override
    public Category readFrom(Class<Category> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        ...
    }