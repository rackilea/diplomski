public class CountryDeserializer extends JsonDeserializer<CountryCode> {
     @Override
     public CountryCode deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
         return CountryCode.getByCode(jp.getText());
     }
 }