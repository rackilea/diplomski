package ftp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class MultiConnection implements Runnable{
    private Socket cSocket;

    public MultiConnection(Socket client) {
        cSocket = client;
        System.out.println("Connected!");
    }

    @Override
    public void run() {
        OutputStream os = null;
        DataOutputStream dos = null;
        try {
            os = cSocket.getOutputStream();
            dos = new DataOutputStream(os);
        } catch (SocketException es) {
            es.printStackTrace();
        } catch (IOException e) {
            System.exit(-1);
        }

        MultiIO mio;
        mio = new MultiIO(dos);
        Thread thio = new Thread(mio);
        thio.start();
    }
}