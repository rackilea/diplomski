@ServerEndpoint(value="/path/")
public class MyEndpoint
{
    @OnOpen
    public void onWebSocketConnect(javax.websocket.Session session)
    {
        synchronized(Core.webSockets)
        {
            Core.webSockets.add(this);
        }
        ...
    }