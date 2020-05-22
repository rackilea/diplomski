public class MessageDeserializer implements JsonDeserializer<TopicLine> {
  private static class InternalParseLine {
    String messageType;
    JsonElement message;
  }

  private Map<String, Topic<?>> messageTypes = new HashMap<String, Topic<?>>();

  public MessageDeserializer() {
    messageTypes.put("Integer", new Topic<Integer>(Integer.class));
    // other topics
  }

  private static class InternalParseLine {
    String topicId;
    JsonElement message;
  }

  @Override
  public TopicLine deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    InternalParseLine line = context.deserialize(json, InternalParseLine.class);

    TopicLine topicLine = new TopicLine();
    topicLine.topic = topics.get(line.messageType);
    topicLine.message = context.deserialize(line.message, topicLine.topic.getMessageTypeClass());
    return topicLine;
  }
}