@ServerEndpoint("/ws")
public class WebsocketServerEndpoint {
    private CustomWebsocketHandler handler;

    @OnOpen
    public void onOpen(Session session) {
        handler = new CustomWebsocketHandler(session);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        handler.handleClose();
    }
}