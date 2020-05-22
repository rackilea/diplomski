@ServerEndpoint(value="/whatever", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class}) 
public class MessageService {

    @OnMessage
    public void message()...
}