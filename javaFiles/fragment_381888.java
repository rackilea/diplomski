@ApplicationScoped
@ServerEndpoint(value="/shout", encoders = {MessageEncoder.class})
public class ShoutServerEndpoint {

    @Inject
    SessionHandler s;

    @OnOpen
    public void open(Session session, EndpointConfig config) throws Exception {
        s.initSession(session);
    }

    @OnMessage
    public void shout(String text, Session client) {
        System.out.println("Session: " + client + " has text: " + text);
        Message m = new Message();
        try {
            client.getBasicRemote().sendObject(m);//use the encoder to write some dummy message
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (EncodeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        client.getAsyncRemote().sendText(text.toUpperCase());
    }


    @OnClose
    public void onClose(Session client, CloseReason reason){
        System.out.println("Session " + client + " closing for " + reason);
        s.destroySession(client);

    }

    @OnError
    public void onError(Session session, Throwable ex) { 
        System.out.println("error: " + ex.getMessage() );
    }
}