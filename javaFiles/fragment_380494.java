import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 * PIN handler for keystores
 */
public class PinInputHandler implements CallbackHandler {

    private char[] lastPassword;

    public PinInputHandler(){}

    // implement this method to handle the callback
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            if (cb instanceof javax.security.auth.callback.PasswordCallback) {
                javax.security.auth.callback.PasswordCallback pcb = (javax.security.auth.callback.PasswordCallback) cb;
                try {
                    this.lastPassword = // HERE YOUR SWING OR AWT OR ANOTHER WAY TO GET THE PASSWORD FROM THE CLIENT
                } catch (Exception e) {}
                pcb.setPassword(this.lastPassword);
            }
        }
    }
}