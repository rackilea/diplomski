public class EmbeddedResponseDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

private JavaType javaType;

@Override
public Object deserialize( JsonParser jsonParser, DeserializationContext ctxt ) throws IOException {

    ObjectCodec objectCodec = jsonParser.getCodec();

    JsonNode node = objectCodec.readTree(jsonParser);

    // Get first it might require correction
    String fieldName = node.fieldNames().next();

    JsonNode skippedNode = node.get( fieldName );

    return objectCodec.readValue( skippedNode.traverse(), javaType );
}

@Override
public JsonDeserializer<?> createContextual( DeserializationContext ctxt, BeanProperty property ) throws JsonMappingException {

    javaType = property.getType();

    return this;
}