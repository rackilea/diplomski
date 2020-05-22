import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

class ServiceResponseDeserializer extends StdDeserializer<ServiceResponse> {

    protected ServiceResponseDeserializer() {
        super(ServiceResponse.class);
    }

    @Override
    public ServiceResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        ObjectNode root = mapper.readTree(p);
        if (root.get("errorMsg") != null) { // found negative token
            NegativeServiceResponse result = new NegativeServiceResponse();
            result.errorCode = root.get("errorCode").asText();
            result.errorMsg = root.get("errorMsg").asText();
            return result;

            // OR (shorter but less efficient due to object-back-to-string conversion)

            return mapper.readValue(root.toString(), NegativeServiceResponse.class);
        } else {
            return mapper.readValue(root.toString(), PositiveServiceResponse.class);
        }
    }
}