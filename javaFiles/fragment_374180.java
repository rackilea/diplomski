import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    import org.codehaus.jackson.JsonNode;
    import org.codehaus.jackson.JsonParser;
    import org.codehaus.jackson.ObjectCodec;
    import org.codehaus.jackson.map.DeserializationContext;
    import org.codehaus.jackson.map.JsonDeserializer;
    import org.codehaus.jackson.map.ObjectMapper;

    class ExtensionDeSerializer extends JsonDeserializer<List<Extension>> {
        @Override
        public List<Extension> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            List<Extension> result = new ArrayList<Extension>();
            if (node.isObject()) {

                ObjectMapper mapper = new ObjectMapper();
                // @firetrap less obscure and better solution
                //result.add(jacksonHelper.getMapper().treeToValue(node, Extension.class));

                result = mapper.convertValue(node, mapper.getTypeFactory().constructCollectionType(List.class, Extension.class));
            }
            if (node.isArray()) {
                result.add(jsonParser.readValueAs(Extension.class));
            }
            return result;
        }
    }