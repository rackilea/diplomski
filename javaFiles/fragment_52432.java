// Mapping between session and person name
private static final HashMap<String, String> nameSessionPair = new HashMap<String, String>();

// Getting query params
public static Map<String, String> getQueryMap(String query) {
Map<String, String> map = new HashMap<String, String>();//Maps.newHashMap();
if (query != null) {
        String[] params = query.split("&");
        for (String param : params) {
    String[] nameval = param.split("=");
    map.put(nameval[0], nameval[1]);
        }
}
return map;
}

private String message = "";
private String to = "";
private String from = "";


@OnOpen
public void open(Session session) {
    System.out.println("Connected with session ID "+session.getId()+" : "+session.getQueryString());
    Map<String, String> campusian = getQueryMap(session.getQueryString());
    String campusianName = "";
    if (campusian.containsKey("name")) {
        campusianName = campusian.get("name");
        try {
            campusianName = URLDecoder.decode(campusianName, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CampusianChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //Mapping session ID with campusian
        nameSessionPair.put(campusianName, session.getId());
        sessions.add(session);
}

@OnMessage
public void message(String message, Session session) {
    //Get Gson string as message
    Gson gson = new Gson();
    Campusian campusian = gson.fromJson(message, Campusian.class);
    //Get the message, from (the sender) and to (the user you are sending the msg to)
    this.message = campusian.getMessage();
    this.from = campusian.getFrom();
    this.to = campusian.getTo();
    System.out.println("From: "+from);
    System.out.println("To: "+to);
    try {
        for (Session s : sessions) {
             //Check for the recepient session id. If it exist send message
            if (nameSessionPair.get(this.to).equals(s.getId())) {
                System.out.print("True");
                Campusian c = new Campusian();
                c.setMessage(this.message);

                //Send message in Gson as string
                s.getBasicRemote().sendText(gson.toJson(c));
                break;
            }
        }

    } catch (IOException ex) {
        Logger.getLogger(CampusianChat.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@OnClose
public void close(Session session) {

}