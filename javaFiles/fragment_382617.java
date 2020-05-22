class Sender{
    public void send(String message){
            for(Session session:WebsocketEndPoint.clients){
                session.getBasicRemote().sendText(message);
            }
        }
    }