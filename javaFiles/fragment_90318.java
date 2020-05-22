@Getter @Setter
public class Request {
    private String type;
    @Getter @Setter
    public static class Content {
        String password;
    }
}