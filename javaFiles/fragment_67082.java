import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Future;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class ExampleClient
{
    public static class ExampleSocket extends WebSocketAdapter
    {
        @Override
        public void onWebSocketText(String message)
        {
            try
            {
                // echo the message
                getRemote().sendString(message);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {
            new ExampleClient().demo();
        }
        catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }

    public void demo() throws Exception
    {
        WebSocketClient client = new WebSocketClient();
        try
        {
            client.start();
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            request.setSubProtocols("xsCrossfire");
            request.setHeader("Authorization","Basic TLVWQMZqRr2hasYnZoI=");

            URI wsUri = URI.create("ws://iltlvl262:8000/echo");

            ExampleSocket socket = new ExampleSocket();
            Future<Session> future = client.connect(socket,wsUri,request);

            future.get(); // wait for connect

            socket.getRemote().sendString("hello"); // send message
        }
        finally
        {
            client.stop();
        }
    }
}