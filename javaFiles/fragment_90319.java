@Getter @Setter
public class ForwardRequest extends Request {
    @Getter @Setter
    public static class ForwardContent extends Content {
        private String deviceId;
    }
    private ForwardContent content;
}