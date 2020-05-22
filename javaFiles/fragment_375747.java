public enum MessageType
{
    KICK     (0x01),
    US_PING  (0x02),
    GOAL_POS (0x04),
    SHUTDOWN (0x08);

    private byte value;
    MessageType(byte value) { this.value = value; }
    byte getValue() { return value; }
}

public class MessageTest
{
    public static void main(String[] args)
    {
        int b = MessageType.values().length;    //Should be happy :-)
    }
}