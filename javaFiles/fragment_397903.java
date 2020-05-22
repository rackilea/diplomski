package natives;

import java.awt.Component;

/**
 *
 * @author Brandon
 */
public class Natives {
    static {
        System.loadLibrary("Redirector");
    }

    public native static void RedirectOutput(Component comp);
    public native static void ResetOutput();
}