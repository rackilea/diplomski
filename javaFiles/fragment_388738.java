public class PacketInChat extends Packet
{
    private Map<InputStream, DataInputStream> map = new WeakHashMap<>();
    private String message;

    public PacketInChat() { }

    public PacketInChat(String message) {
        this.message = message;
    }

    @Override
    public void readFrom(InputStream stream) throws IOException {
        DataInputStream din;
        synchronized (map)
        {
            if ((din = map.get(stream)) == null)
            {
                map.put(din, in = new DataInputStream(stream));
            }
        }
        message = din.readUTF();
    }

}