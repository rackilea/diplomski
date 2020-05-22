import com.google.gwt.user.client.Timer;

public class ClientTimers {

    private static final Timer SESSION_MAY_HAVE_EXPIRED_TIMER = new Timer() {

        @Override
        public void run() {
            // Warn the user, that the session may have expired.
            // You could then show a login dialog, etc...
        }
    };

    public static void renewSessionTimer() {

        // First cancel the previous timer
        SESSION_MAY_HAVE_EXPIRED_TIMER.cancel();

        // Schedule again in 5 minutes (maybe make that configurable?)
        // Actually, let's subtract 10 seconds from that, because our timer
        // won't be synchronized perfectly with the server's timer.
        SESSION_MAY_HAVE_EXPIRED_TIMER.schedule(5 * 60 * 1000 - 10000);
    }
}