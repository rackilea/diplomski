public class Views {
    static class HeartbeatAPI { }
}

public class MyBean implements Serializable {
    private String fName;
    private lName;
    private address;

    @JsonView(Views.HeartbeatAPI.class)
    private Date currentTime;

    // Constructors, Getters/Setters
}

final MyBean bean = new MyBean();
final ObjectMapper mapper = new ObjectMapper().configure(
    SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);;
final ObjectWriter writer = mapper.writerWithView(Views.HeartbeatAPI.class);
final String json = writer.writeValueAsString(bean);