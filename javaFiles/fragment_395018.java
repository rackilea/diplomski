import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

public class Program
{
    public static class Packet
    {
        public Message[] DATA;
    }

    public static enum MessageType
    {
        WHOAREYOU,
        TimeData,
        Ready,
        LocationData
    }

    //my parent message class:
    public static class Message {

        public MessageType getMessageType() {
            return MESSAGE_TYPE;
        }

        public void setMessageType(MessageType MessageType) {
            this.MESSAGE_TYPE = MessageType;
        }

        private MessageType MESSAGE_TYPE;
        //declaring public for simplicity
        public String SENDER;
        public String SENDER_TYPE;

    }

    //sample child class:
    public static class TimeMessage extends Message
    {
        private int tick;
        public int getTick()
        {
            return tick;
        }
        public TimeMessage(int tick)
        {
            this.tick = tick;
        }
    }

    public static void main(String[] args)
    {
        Message[] messages = { new TimeMessage(123) };

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(Message.class, "$type").registerSubtype(TimeMessage.class));
        Gson gson = builder.create();

        String json = gson.toJson(messages);

        Message[] outMessages = gson.fromJson(json, Message[].class);
        TimeMessage tm = (TimeMessage)outMessages[0];
    }
}