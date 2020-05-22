package ftp;

import java.io.DataOutputStream;
import java.io.IOException;

public class MultiIO implements Runnable{
    private DataOutputStream dos;

    public MultiIO(DataOutputStream stream) {
        dos = stream;
        System.out.println("Set OutputStream.");
    }

    @Override
    public void run() {
        try {
            dos.writeBytes("220");
            dos.flush();
            System.out.println("tried once");
        } catch (IOException e) {
            System.exit(-1);
        }
    }
}