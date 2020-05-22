import java.io.IOException;
    import java.util.ResourceBundle;
    import javax.security.auth.callback.Callback;
    import javax.security.auth.callback.CallbackHandler;
    import javax.security.auth.callback.UnsupportedCallbackException;
    import org.apache.wss4j.common.ext.WSPasswordCallback;

    public class ClientPasswordCallback implements CallbackHandler {

        private static final String BUNDLE_LOCATION = "auth2";
        private static final String PASSWORD_PROPERTY_NAME = "auth.manager.password";
        private static String password;

        static {
            final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_LOCATION);
            password = bundle.getString(PASSWORD_PROPERTY_NAME);
        }

        @Override
        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
            pc.setPassword(password);
        }
    }