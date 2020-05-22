package foo.bar;

import java.io.IOException;
import java.net.Socket;

public final class MySingletonSocket extends Socket {

    private static Socket clientSocket;

    static {
        try {
            clientSocket = new MySingletonSocket("localhost", 4444);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MySingletonSocket(final String address, final int port) throws IOException {
        super(address, port);
    }

    public static final Socket getInstance() {
        return clientSocket;
    }

}