@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE) // Don't detect `getSource` from ApplicationEvent
public class ExternalApplicationEvent extends ApplicationEvent {

    // I might use @JsonUnwrapped probably, but since I have to create setters
    // and getters anyway...
    private ExternalApplicationEventData p = new ExternalApplicationEventData();

    public ExternalApplicationEvent(Object source, ExternalApplicationEventData data) {
        super(source);
        p = data;
    }

    @JsonGetter("name")
    public String getName() { return p.name; }

    public void setName(String name) { p.name = name; }

    public static class ExternalApplicationEventData {

        @JsonCreator
        private ExternalApplicationEventData() {} // Make creation only possible by parsing or from the ExternalApplicationEvent class

        @JsonProperty
        private String name;

        ...
    }
}