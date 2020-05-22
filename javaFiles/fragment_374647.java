import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
//...

@ServerEndpoint("/move")
public class TestWebSocketEndPoint {//@OnMessage 
public void onMessage(Session session, String message) {}
private static final Queue<Session> QUEUE = new ConcurrentLinkedQueue<Session>();

@OnOpen
public void open(Session session) {
    QUEUE.add(session);
}

@OnError
public void error(Session session, Throwable t) {
    StaticLogger.log(TestWebSocketEndPoint.class, t);
    QUEUE.remove(session);
}

@OnClose
public void closedConnection(Session session) {
    QUEUE.remove(session);
}

public static void sendToAll(String message) throws IOException {
    ArrayList<Session> closedSessions = new ArrayList<Session>();
    for (Session session : QUEUE) {
        if (!session.isOpen()) {
            closedSessions.add(session);
        } else {
            session.getBasicRemote().sendText(message);
        }
    }
    QUEUE.removeAll(closedSessions);
}
}