import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author martijncourteaux
 */
public class SJPhoneRinger
{

    private static String setupOpenLogicChannel = "03|00|02|32|08|02|10|00|05|04|03|88|c0|a5|28|07|75|6e|6b|6e|6f|77|6e|6c|05|81|32|30|30|35|7e|02|11|05|20|88|06|00|08|91|4a|00|04|22|c0|00|00|00|00|0f|53|4a|20|4c|61|62|73|ae|20|53|4a|70|68|6f|6e|65|08|31|2e|36|30|2e|32|39|39|61|00|7f|00|00|01|06|b8|00|c4|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|00|c1|1d|80|04|11|00|f6|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|81|3a|0a|21|40|00|00|06|04|01|00|4e|0c|03|00|20|00|80|12|1e|00|01|00|7f|00|00|01|c0|04|00|7f|00|00|01|c0|05|00|2b|40|00|00|06|04|01|00|4c|10|00|00|00|00|09|69|4c|42|43|2d|31|33|6b|33|80|12|1e|40|01|00|7f|00|00|01|c0|04|00|7f|00|00|01|c0|05|04|2b|40|00|00|06|04|01|00|4c|10|00|00|00|00|09|69|4c|42|43|2d|31|35|6b|32|80|12|1e|40|01|00|7f|00|00|01|c0|04|00|7f|00|00|01|c0|05|08|1e|40|00|00|06|04|01|00|4c|20|13|80|12|1e|00|01|00|7f|00|00|01|c0|04|00|7f|00|00|01|c0|05|00|1e|40|00|00|06|04|01|00|4c|60|13|80|12|1e|00|01|00|7f|00|00|01|c0|04|00|7f|00|00|01|c0|05|00|16|00|00|0d|0e|0c|03|00|20|00|80|0b|06|00|01|00|7f|00|00|01|c0|05|00|20|00|00|0e|0c|10|00|00|00|00|09|69|4c|42|43|2d|31|33|6b|33|80|0b|06|40|01|00|7f|00|00|01|c0|05|04|20|00|00|0f|0c|10|00|00|00|00|09|69|4c|42|43|2d|31|35|6b|32|80|0b|06|40|01|00|7f|00|00|01|c0|05|08|13|00|00|10|0c|20|13|80|0b|06|00|01|00|7f|00|00|01|c0|05|00|13|00|00|11|0c|60|13|80|0b|06|00|01|00|7f|00|00|01|c0|05|00|01|00|01|00|01|00|01|00|6e|02|64|02|70|01|06|00|08|81|75|00|08|80|0d|00|00|3c|00|01|00|00|01|00|00|01|00|00|04|80|00|00|24|18|03|00|20|00|80|00|01|20|20|00|00|00|00|09|69|4c|42|43|2d|31|33|6b|33|80|00|02|20|20|00|00|00|00|09|69|4c|42|43|2d|31|35|6b|32|80|00|03|20|40|13|80|00|04|20|c0|13|00|80|06|00|04|00|00|00|01|00|02|00|03|00|04|07|01|00|32|80|d8|50|5f|02|80|01|80";
    private static String alertingTSCA = "03|00|00|d8|08|02|90|00|01|28|07|75|6e|6b|6e|6f|77|6e|7e|00|c3|05|23|c0|06|00|08|91|4a|00|04|22|c0|00|00|00|00|0f|53|4a|20|4c|61|62|73|ae|20|53|4a|70|68|6f|6e|65|08|31|2e|36|30|2e|32|38|39|61|00|5e|e0|cc|44|98|ff|0d|0c|11|00|f6|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|01|00|01|00|04|c0|01|80|74|04|03|21|80|01|64|02|70|01|06|00|08|81|75|00|08|80|0d|00|00|3c|00|01|00|00|01|00|00|01|00|00|04|80|00|00|24|18|03|00|20|00|80|00|01|20|20|00|00|00|00|09|69|4c|42|43|2d|31|33|6b|33|80|00|02|20|20|00|00|00|00|09|69|4c|42|43|2d|31|35|6b|32|80|00|03|20|40|13|80|00|04|20|c0|13|00|80|06|00|04|00|00|00|01|00|02|00|03|00|04|06|01|00|32|40|1b|33|02|20|80";
    private static String facilityTSCA = "03|00|00|62|08|02|10|00|62|1c|00|28|07|75|6e|6b|6e|6f|77|6e|7e|00|4b|05|26|90|06|00|08|91|4a|00|04|c4|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|86|01|00|13|05|80|11|00|f6|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|07|00|5e|e0|cc|44|ab|62|01|00|01|00|04|c0|01|80|08|02|03|21|80|01|02|20|a0";
    private static String connectOpenLogicChannel = "03|00|00|b6|08|02|90|00|07|28|07|75|6e|6b|6e|6f|77|6e|7e|00|a1|05|22|c0|06|00|08|91|4a|00|04|00|5e|e0|cc|44|98|ff|22|c0|00|00|00|00|0f|53|4a|20|4c|61|62|73|ae|20|53|4a|70|68|6f|6e|65|08|31|2e|36|30|2e|32|38|39|61|00|c4|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|0d|1c|11|00|f6|a1|56|3c|d2|1d|b2|11|a8|ed|b7|8a|c2|c1|98|8f|41|02|21|40|00|03|06|04|01|00|4e|0c|03|00|20|00|80|12|1e|00|01|00|7f|00|00|01|c0|04|00|5e|e0|cc|44|c0|07|00|1d|00|00|0d|0e|0c|03|00|20|00|80|12|1e|00|01|00|5e|e0|cc|44|c0|06|00|5e|e0|cc|44|c0|07|00|01|00|01|00|02|80|01|80";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 1720);
        System.out.println("Connected to SJPhone!");

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        sendBytes(dos, setupOpenLogicChannel);

        /* Following three packages were not needed. It worked without them.
         * Of course, because it is only a sample ring request, SJPhone will tell you
         * That the call is corrupted */
//        sendBytes(dos, alertingTSCA);
//        sendBytes(dos, facilityTSCA);
//        sendBytes(dos, connectOpenLogicChannel);

        try
        {
            Thread.sleep(10000); // Let it ring for ten seconds.
        } catch (Exception e)
        {
        }
    }

    public static void sendBytes(OutputStream os, String bytes) throws IOException
    {
        String byteArrayStr[] = bytes.split("\\|");
        byte bytesArray[] = new byte[byteArrayStr.length];
        for (int i = 0; i < byteArrayStr.length; ++i)
        {
            bytesArray[i] = (byte) (Integer.parseInt(byteArrayStr[i],16));
        }
        os.write(bytesArray);
        os.flush();
    }


}