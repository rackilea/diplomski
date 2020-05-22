@OnMessage
public String onTextMessage(Session session, String msg)
{
    List<String> originHeader = (List<String>)session.getUserProperties()
                                                     .get("TheUpgradeOrigin");

    // Do something with this header

    return msg;
}