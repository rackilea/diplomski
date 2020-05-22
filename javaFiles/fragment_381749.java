/**
 * <p>
 * Serializes the values of some map into a list.
 * <p>
 *
 * @author John Jenkins
 */
public class MapValuesJsonSerializer extends JsonSerializer<Map<?, ?>> {
    /*
     * (non-Javadoc)
     * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
     */
    @Override
    public void serialize(
        final Map<?, ?> value,
        final JsonGenerator generator,
        final SerializerProvider provider)
        throws IOException, JsonProcessingException {

        provider.defaultSerializeValue(value.values(), generator);
    }
}