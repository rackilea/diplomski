// this is the class used to send the packets (data)
public class QueueItem
{
    private static final String defaultIP = "192.168.1.150";
    private static final short defaultPort = 3030;
    public byte[] data = null;
    public String dstIP;
    public short dstPort;

    public QueueItem(byte[] theData) {
        this(theData, "", 0);
    }

    public QueueItem(byte[] theData, String theIP) {
        this(theData, theIP, 0);
    }

    public QueueItem(byte[] theData, String theIP, int thePort) {
        this.data = null;
        if (theData != null && theData.length > 0)
        {
            data = new byte[theData.length];
            for (int i = 0; i < theData.length; i++)
                this.data[i] = theData[i];
        }
        if (theIP.trim().length() > 0) this.dstIP = theIP.trim();
        else this.dstIP = defaultIP; // for example
        if (thePort != 0) this.dstPort = (short) thePort;
        else this.dstPort = defaultPort; // for example
    }
}