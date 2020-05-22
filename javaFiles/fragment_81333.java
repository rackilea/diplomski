package com.stackoverflow.q56304773;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PacketSender {
    private OutputStream networkStream;
    public void sendObject(Object o,String objInfo) throws IOException {
        try(BufferedOutputStream out=new BufferedOutputStream(getNetworkStream());
                ObjectOutputStream objectSender=new ObjectOutputStream(out);
                PrintWriter infoWriter=new PrintWriter(out)){
            infoWriter.printf("Object:%s", objInfo);
            objectSender.writeObject(o);
        }
    }
    public OutputStream getNetworkStream() {
        return networkStream;
    }
    public void setNetworkStream(OutputStream networkStream) {
        this.networkStream = networkStream;
    }
}


package com.stackoverflow.q56304773;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class PacketResciever {
    private InputStream networkStream;
    public void resv() throws IOException, ClassNotFoundException {
        try(BufferedInputStream in=new BufferedInputStream(getNetworkStream());
                BufferedReader infoReader=new BufferedReader(new InputStreamReader(in))){
            String header=infoReader.readLine();
            String[] splitted=header.split(":");
            switch(splitted[0]) {
                case "Object":
                    handleObject(new ObjectInputStream(in).readObject(),splitted[1]);
                    break;
                //other cases
            }

        }
    }
    private void handleObject(Object readObject,String info) {
        //search for handler and execute it
    }
    public InputStream getNetworkStream() {
        return networkStream;
    }
    public void setNetworkStream(InputStream networkStream) {
        this.networkStream = networkStream;
    }
}