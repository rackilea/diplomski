package tr.com.calikbank.bnspr.treasury.reutersClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {

    /**
     * @param args
     */

    public static final String FS = Character.toString((char) 28);
    public static final String US = Character.toString((char) 31);
    public static final String GS = Character.toString((char) 29);
    public static final String RS = Character.toString((char) 30);

    private static DataInputStream in;
    private static Socket sock;
    private static DataOutputStream out;

    public static void main(String[] args) throws UnknownHostException,
            IOException {
        // TODO Auto-generated method stub

        sock = new Socket("127.0.0.1", 5003);
        sock.setKeepAlive(true);

        in = new DataInputStream(sock.getInputStream());
        out = new DataOutputStream(sock.getOutputStream());

        String message = FS + "333" + US + "AE" + GS + "AAAA#1" + FS;
          //String message=FS+"332"+US+"XX"+GS+"AAAA#INFO"+FS;

        out.flush();
        out.writeBytes(message);
        out.flush();

        // BufferedReader reader = new BufferedReader(new
        // InputStreamReader(sock.getInputStream()));
        StringBuilder sb = new StringBuilder();

        int i=0;
        // line = reader.readLine();
        while (true)
        {
            byte[] inputData = new byte[5000];
            in.read(inputData);

            sb.append(new String(inputData));
            i++;
            if (i==3)
                break;

        }
        // line = in.readLine();
        // sb.append(line).append("\n");

        System.out.println("Message received from the server : "
                + sb.toString());

        String temps=new String(sb.toString());
        String temps2=new String(sb.toString());

        String[] partsUS = temps.split(US);

        for (int j=0;i<partsUS.length;i++)
        System.out.println(partsUS[i]); // 340


        String[] partsRS = temps2.split(RS);

        System.out.println("-----------");

        for (int j=0;j<partsRS.length;j++)
            System.out.println(partsRS[j]); // 340





    }

}