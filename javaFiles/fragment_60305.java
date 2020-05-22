//Define a variable to indicate network settings has been done.
public static boolean NETWORK_SETTINGS_DONE = false;

public static Object LOCK = new Object();

public void doSometing() {
    try {

    } catch (Exception e) {
        synchronized (LOCK) {
            if (!NETWORK_SETTINGS_DONE) {
                //do some changes to your network settings.
                NETWORK_SETTINGS_DONE=true;                               
            }
        }
    }
}