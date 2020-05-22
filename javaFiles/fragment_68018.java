public class MessageEvent {
        public final String SendViewProfileName;
        public final String SendViewProfileEmail;
        // similarly other params

        public MessageEvent(String SendViewProfileName, String SendViewProfileEmail, ...) {
            this.SendViewProfileName = SendViewProfileName;
            this.SendViewProfileEmail = SendViewProfileEmail;
            // similarly other params
        }
    }