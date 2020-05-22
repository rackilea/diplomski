import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.io.Reader;

public class DataDecoder implements    Decoder.TextStream<Object> {

@Override
public Object decode(Reader reader) throws DecodeException, IOException {

    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(reader, new TypeReference<Object>() {
    });

}

@Override
public void init(EndpointConfig config) {

}

@Override
public void destroy() {

}
}



@ClientEndpoint (decoders = { DataDecoder.class })
public class SomeClass  {


private WebSocketContainer container;

private Session session;
private Object objectModel;

@Override
public SomeType getAimedJobs() throws DatabaseException, ModuleNotLoadException, NamingException {



    SomeType someType = new SomeType ();
    ObjectMapper mapper = new ObjectMapper();
    try {
        String jsonInString =    mapper.writeValueAsString(this.objectModel);
        someType = mapper.readValue(jsonInString, SomeType.class);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return someType ;
}


@OnOpen
public void onOpen(Session session) {

    this.session = session;
}

@OnMessage
public void onMessage(Object o) {

    this.objectModel = o;
}

@OnClose
public void onClose(CloseReason reason) {

    System.out.println("WebSocket connection closed with CloseCode: " + reason.getCloseCode());
    this.session.Close();
}