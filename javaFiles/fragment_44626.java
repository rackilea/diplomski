import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NetworkMarshall {

private static final int NumberOfMsgs = 2;

public static void main(String[] args) {

    Socket s = null;
    try {
        JAXBContext jc = JAXBContext.newInstance(NetworkMarshall.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        new Thread(new Receiver(unmarshaller)).start();
        // Wait for socket server to start
        Thread.sleep(500);
        s = new Socket(InetAddress.getLocalHost(), 54321);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        for (int i = 0; i < NumberOfMsgs; i++) {
            NetworkMarshall msg = new NetworkMarshall();
            msg.setName("vanOekel" + i);
            writeMsg(msg, marshaller, dos);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { s.close(); } catch (Exception ignored) {}
    }
}

private static void writeMsg(NetworkMarshall msg, Marshaller marshaller, DataOutputStream dos) throws Exception {

    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    marshaller.marshal(msg, bout);
    byte[] msgBytes = bout.toByteArray();
    System.out.println("Sending msg: " + new String(msgBytes));
    dos.writeInt(msgBytes.length);
    dos.write(msgBytes);
    dos.flush();
}

private String name;

public void setName(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public String toString() {
    return this.getClass().getName() + ": " + getName();
}

static class Receiver implements Runnable {

    final Unmarshaller unmarshaller;

    public Receiver(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void run() {

        ServerSocket ss = null;
        Socket s = null;
        try {
            s = (ss = new ServerSocket(54321)).accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            for (int i = 0; i < NumberOfMsgs; i++) {
                Object o = unmarshaller.unmarshal(readMsg(dis));
                System.out.println("Received message " + i + ": " + o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { ss.close(); } catch (Exception ignored) {}
            try { s.close(); } catch (Exception ignored) {}
        }
    }

    private ByteArrayInputStream readMsg(DataInputStream dis) throws Exception {

        int size = dis.readInt();
        byte[] ba = new byte[size];
        dis.readFully(ba);
        return new ByteArrayInputStream(ba);
    }
}
}