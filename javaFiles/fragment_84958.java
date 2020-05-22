public class ExampleAbstractMessageTransformer extends AbstractMessageTransformer {

@Override
public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException  {
    // TODO Auto-generated method stub
    HashMap<String, String> payload = new HashMap<String, String>();
    String websiteUrl = new String();

    //Grab Payload
    payload = (HashMap<String, String>) message.getPayload();
    try {
        websiteUrl = stringToURL(payload.get("Website").toString());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }


    message.setInvocationProperty("websiteUrl", websiteUrl);
    return message;
}

public String stringToURL(String string) throws MalformedURLException {
    return new java.net.URL(string).toString();
}
}