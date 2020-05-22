@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ClassA.class, name = "ClassA"),
        @JsonSubTypes.Type(value = ClassB.class, name = "ClassB")
})
public interface NotificationPayload {
}

public class ClassA implements NotificationPayload {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

public class Notification <T extends NotificationPayload> {

    private T data; //T may be ClassA/ClassB/ClassC.../ClassX

    @JsonCreator
    public Notification(T data) {
        this.data = data;
    }

    public static void main(String[] args) throws IOException {

        String jsonStr = "{\"type\":\"ClassB\",\"userId\":10087}";

        ObjectMapper objectMapper = new ObjectMapper();
        Notification notification = objectMapper.readValue(jsonStr, Notification.class);
    }
}