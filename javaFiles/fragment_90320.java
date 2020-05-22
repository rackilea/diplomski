@Getter @Setter
public class LoginRequest extends Request  {
    @Getter @Setter
    public static class LoginContent extends Content {
        private String username;
    }
    private LoginContent content;
}