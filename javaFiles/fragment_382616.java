@ServerEndpoint(value = "/websocket/one")
    public class WebsocketEndPoint {
        public static List clients=new ArrayList();

        @OnOpen
        public void OnOpen(Session session, EndpointConfig config)
                throws IOException {
            //Save the endpoints session that opened the connection in List
        }

        @OnMessage
        public void OnMessage(Session session, String message) {


        }

        @OnClose
        public void OnClose(Session session, CloseReason reason) {
         //remove from list
        }

        @OnError
        public void OnError(Session session, Throwable throwable) {



            }
        }
    }