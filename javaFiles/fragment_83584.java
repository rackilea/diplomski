public class ChatActivity extends AppCompatActivity
{
    // private fields
    HubConnection connection;
    HubProxy hub;
    ClientTransport transport;

    protected void onCreate(Bundle savedInstanceState) {

        Logger logger = new Logger() {
            @Override
            public void log(String message, LogLevel logLevel) {
                Log.e("SignalR", message);
            }
        };

        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        connection = new HubConnection("192.168.1.100");
        hub = connection.createHubProxy("chatHub"); // case insensitivity

        /* ****new codes here**** */
        hub.subscribe(this);

        transport = new LongPollingTransport(connection.getLogger());

        /* ****new codes here**** */
        connection.start(transport);

        /* ****new codes here**** */
        /* ****seems useless but should be here!**** */
        hub.subscribe(new Object() {
            @SuppressWarnings("unused")
            public void newMessage(final String message, final String messageId, final String chatId,
                                   final String senderUserId, final String fileUrl, final String replyToMessageId) {


            }
        });


        /* ********************** */
        /* ****new codes here**** */
        /* **** the main method that I fetch data from server**** */
        connection.received(new MessageReceivedHandler() {
            @Override
            public void onMessageReceived(final JsonElement json) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        JsonObject jsonObject = json.getAsJsonObject();
                        Log.e("<Debug>", "response = " + jsonObject.toString());

                    }
                });
            }
        });
        /* ********************** */

    }
}