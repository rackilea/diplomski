@Component
@SuppressWarnings("serial")
public class ActivityPojoJsonModule extends SimpleModule {

    public ActivityPojoJsonModule() {
        this.addDeserializer(ActivityPojo.class, new ActivityPojoDeserializer());
    }

    public static class ActivityPojoDeserializer extends JsonDeserializer<ActivityPojo> {

        @Override
        public ActivityPojo deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);
            if(this.isDrug(node)) {
                return codec.treeToValue(node, DrugPojo.class);
            }
            return codec.treeToValue(node, ObservationPojo.class);
        }

        private boolean isDrug(JsonNode node) {
            return node.get("categoryCode").asText().equals("drug");
        }
    }
}