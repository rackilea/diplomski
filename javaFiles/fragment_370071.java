@Component("usernameTokenWssConfig")
public class usernameTokenWssConfigWSSConfig {
    public usernameTokenWssConfig() {
        setValidator(WSSecurityEngine.USERNAME_TOKEN, new CustomUsernameTokenValidator());
        setRequiredPasswordType(WSConstants.PASSWORD_TEXT);
    }
}