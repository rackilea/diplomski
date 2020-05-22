public class PacketInChat
{
    DataInputStream din;
    DataOutputStream dout;

    public PacketInChat(InputStream in, OutputStream out)
    {
        this.din = new DataInputStream(in);
        this.dout = new DataOutputStream(out);
    }

    public String readMessage() throws IOException { return din.readUTF(); }
    public int readInt() throws IOException { return din.readInt(); }
    // etc
    public void writeMessage(String msg) throws IOException
    {
        dout.writeUTF(msg);
    }
    // etc
}