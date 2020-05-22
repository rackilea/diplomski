import java.nio.ByteBuffer;
import java.nio.ByteOrder;

static byte[] buildPacket(int magicNumber, String payload) throws UnsupportedEncodingException
{
  // 4 bytes for header + payload
  ByteBuffer buffer = ByteBuffer.allocate(2 + 2 + payload.length());
  // we set that we want big endian numbers
  buffer.order(ByteOrder.BIG_ENDIAN);

  buffer.putShort((short)magicNumber);
  buffer.putShort((short)payload.length());
  buffer.put(payload.getBytes("US-ASCII"));
  return buffer.array();
}

public static void main (String[] args) throws java.lang.Exception
{
    try
    {
        byte[] bytes = buildPacket(0xFF10, "foobar");
        for (byte b : bytes)
          System.out.printf("0x%02X ", b);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}