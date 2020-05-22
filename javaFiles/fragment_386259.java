public class RequestSerializer extends StdSerializer<Request> {

    public RequestSerializer() {
        super(Request.class);
    }

    @Override
    public void serialize(Request request, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeStartObject();
        jgen.writeObjectField("HeaderInfo", request.getHeaderInfo());
        String name = request.getRequest().getClass().getSimpleName();
        jgen.writeObjectField(name, request.getRequest());
        jgen.writeEndObject();
    }
}



    JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(true);
    module.addSerializer(Request.class, new RequestSerializer());
    XmlMapper xml = new XmlMapper(module);