public class ResponseDeserializer extends StdDeserializer<Response> {
    public ResponseDeserializer() { 
        this(null); 
    } 

    public ResponseDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public Response deserialize(JsonParser jp, DeserializationContext dc)
            throws IOException, JsonProcessingException {
        Response resp = new Response();
        resp.parameters = new HashMap<>();
        JsonNode node = jp.getCodec().readTree(jp);
        ArrayNode parms = (ArrayNode)node.get("parameters");
        for (JsonNode parm: parms) {
            String key = parm.get("key").asText();
            String value = parm.get("value").asText();
            resp.parameters.put(key, value);
        }
        return resp;
    }   
}