package com.beniregev.injector.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketOutput implements OutputHandler {

    private static final Logger log = LoggerFactory.getLogger(SocketOutput.class);

    public static final String CLI_OPTION = "socket";
    private int outputIndex = 0;

    @Value("${socket.hostname}")
    private String hostname;
    @Value("${socket.port}")
    private int port;
    Socket clientSocket;

    public boolean open() {
        try {
            clientSocket = new Socket(hostname, port);
        } catch (IOException ioe) {
            log.error("", ioe);
            return false;
        }
        return true;
    }

    @Override
    public void output(String data) {
        DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes( data );
            outputIndex++;
        } catch (IOException ioe) {
            log.error("", ioe);
        }
        System.out.println("Wrote segment " + outputIndex + " to socket");

    }

}