public interface Event {
}

public static class Input
{
    private Event event;

    @JsonDeserialize(using = UserEventDeserializer.class)
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}

public enum UserEvent implements Event
{
    SIGNUP;
}

public static class UserEventDeserializer  extends StdDeserializer<Event> {

    protected UserEventDeserializer() {
        super(Event.class);
    }

    @Override
    public Event deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return UserEvent.valueOf(p.getText());
    }
}

@Test
public void converEnum() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Input input = objectMapper.readValue("{\n" +
            "  \"event\" : \"SIGNUP\"\n" +
            "}", Input.class);

    Assert.assertThat(input.getEvent(), Matchers.is(UserEvent.SIGNUP));
}