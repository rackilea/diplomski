import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.*;
import microsoft.aspnet.signalr.client.hubs.*;
import microsoft.aspnet.signalr.client.transport.*;

import com.google.gson.JsonElement;

public class Client {

public static void main(String[] args) throws Exception {

    // Initialize the Logger
    Logger logger = new Logger() {

        @Override
        public void log(String message, LogLevel level) {
            System.out.println(message);
        }
    };

    String serverUri = "http://localhost:8080/signalr";

    // Connection to the Server
    HubConnection conn = new HubConnection(serverUri);

    // To invoke methods in the client, it have to be the same name as in
    // the Server
    HubProxy proxy = conn.createHubProxy("Hub");

    // Initializes the transport with a logger
    ClientTransport transport = new ServerSentEventsTransport(conn.getLogger());

    //Listening to the Server
    proxy.on("machineNotification",new SubscriptionHandler1<SentTestEvent>(){
        @Override
        public void run(SentTestEvent send){
            System.out.println(send.Channel +"|"+send.From+"|"+send.Message+"|"+send.Selector+"|"+send.ToUserId);
            //logger.log("result :="+msg, LogLevel.Information);
        }
    },SentTestEvent.class);

    // Starts the connection synchronously by calling get()
    SignalRFuture<Void> awaitConnection = conn.start(transport);
    try {
        awaitConnection.get();


        System.out.println("Connected to server at "+serverUri);
    } catch (InterruptedException e) {
        logger.log("Check " + e, LogLevel.Information);
        e.printStackTrace();
    } catch (ExecutionException e) {
        logger.log("Check " + e, LogLevel.Information);
        e.printStackTrace();
    }

    // Creates subscriptions for the connection
    proxy.subscribe(awaitConnection);

    System.out.println("connected.Id = "+conn.getConnectionId());
}

public class SentTestEvent{
    String Channel;
    String From;
    String Message;
    String Selector;
    String ToUserId;

    public SentTestEvent(String channel, String from, String message, String selector, String toUserId){
        Channel = channel;
        From = from;
        Message = message;
        Selector = selector;
        ToUserId = toUserId;
    }

}