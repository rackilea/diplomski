@ServerEndpoint(value = "/websocket/{room-name}/{nick-name}", encoders = { ChatMessageEncoder.class }, decoders = { ChatMessageDecoder.class })
public class ChatEndPoint {

    @Inject
    private DAO dao;

    // traitement de la connexion d'un client
    @OnOpen
    public void open(Session session, EndpointConfig conf, @PathParam("room-name") String roomName, @PathParam("nick-name") String nickName) throws Exception {
        System.out.println("connection ouverte");
        session.getUserProperties().put("salle", roomName);
        dao.createConnection(nickName, roomName);