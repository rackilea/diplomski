public class StreamingSocketCreator implements WebSocketCreator
{
    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp)
    {
        return new PacketStreamingSocket();
    }
}