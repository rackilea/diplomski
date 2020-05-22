import com.neovisionaries.ws.client.*;

public class HelloWSS
{
    public static void main(String[] args) throws Exception
    {
        // Connect to "wss://echo.websocket.org" and send "Hello." to it.
        // When a response from the WebSocket server is received, the
        // WebSocket connection is closed.
        new WebSocketFactory()
            .createSocket("wss://echo.websocket.org")
            .addListener(new WebSocketAdapter() {
                @Override
                public void onTextMessage(WebSocket ws, String message) {
                    // Received a response. Print the received message.
                    System.out.println(message);

                    // Close the WebSocket connection.
                    ws.disconnect();
                }
            })
            .connect()
            .sendText("Hello.");
    }
}