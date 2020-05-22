import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebSocket
public class WebsocketExample {

    private Session userSession;
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private void connect() {
        try {
            SslContextFactory sslContextFactory = new SslContextFactory();
            WebSocketClient client = new WebSocketClient(sslContextFactory);
            client.start();
            client.connect(this, new URI("Someaddress"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnWebSocketConnect
    public void onOpen(Session userSession) {
        // Set the user session
        this.userSession = userSession;
        System.out.println("Open");

        executorService.scheduleAtFixedRate(() -> {
                    try {
                        String data = "Ping";
                        ByteBuffer payload = ByteBuffer.wrap(data.getBytes());
                        userSession.getRemote().sendPing(payload);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                },
                5, 5, TimeUnit.MINUTES);
    }

    @OnWebSocketClose
    public void onClose(int code, String reason) {
        this.userSession = null;
        System.out.println("Close");
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        // Do something with the message
        System.out.println(message);
    }
}