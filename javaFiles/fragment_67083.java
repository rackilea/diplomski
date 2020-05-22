import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class ExampleClient
{
    @ClientEndpoint(subprotocols = { "xsCrossfire" }, 
                    configurator = ExampleClient.Configurator.class)
    public static class ExampleSocket
    {
        @OnMessage
        public String onMessage(String msg)
        {
            return msg; // echo
        }
    }

    public static class Configurator 
           extends javax.websocket.ClientEndpointConfig.Configurator
    {
        @Override
        public void beforeRequest(Map<String, List<String>> headers)
        {
            List<String> authvalues = new ArrayList<>();
            authvalues.add("Basic TLVWQMZqRr2hasYnZoI=");
            headers.put("Authorization", authvalues);
            super.beforeRequest(headers);
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
        WebSocketContainer client = ContainerProvider.getWebSocketContainer();

        ExampleSocket socket = new ExampleSocket();
        URI wsUri = URI.create("ws://iltlvl262:8000/echo");

        Session session = client.connectToServer(socket,wsUri);
        session.getAsyncRemote().sendText("Hello");
    }
}