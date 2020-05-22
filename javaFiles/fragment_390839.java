import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

@ServerEndpoint(value = "/test", configurator = Test.TestConfiguratior.class)
public class Test extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        Object o = endpointConfig.getUserProperties().get(TestConfiguratior.HEADER_NAME);
        //o should be the string object you are looking for
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        //do what u want
    }

    public static class TestConfiguratior extends ServerEndpointConfig.Configurator {
        static String HEADER_NAME = "X-Real-IP";

        @Override
        public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
            String firstFoundHeader = request.getHeaders().get(HEADER_NAME.toLowerCase()).get(0);
            sec.getUserProperties().put(HEADER_NAME, firstFoundHeader);
        }
    }
}