public class Deserializer<T> {

  public JsonDeserializer<T> getDeserializer(final Class<T> cls) {
      return new JsonDeserializer<T> (){

         @Override
         public T deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException {
            JsonNode node = jp.readValueAsTree();
            if (node.isObject()) {
              return new ObjectMapper().convertValue(node, cls);
            }
            return null;
         }
     };
}