public class NotificationDeserializer extends JsonDeserializer<Notification> {
    @Override
    public Notification deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String text = p.getText();

        return new ObjectMapper().readValue(text, Notification.class);
    }
}

public class MailDeserializer extends JsonDeserializer<Mail> {
    @Override
    public Mail deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String text = p.getText();

        return new ObjectMapper().readValue(text, Mail.class); 
    }
}