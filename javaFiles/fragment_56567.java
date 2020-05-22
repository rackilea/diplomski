import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class JavaIo {

    // number of bytes in a user name
    private static final int SIZE_OF_USER_NAME = 30;
    // number of bytes in the internal buffer
    private static final int BUFFER_SIZE = 1024;

    public void workWithConnection() {
        final int portNumber = 12345; // TODO: read this from config file or command line arguments instead
        try (
                ServerSocket server = new ServerSocket(portNumber);
                Socket connection = server.accept();
                SocketChannel channel = connection.getChannel();
        ) {
            final ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            channel.read(buffer);   // fill buffer from the input stream
            // since your buffer in GameMaker is unsigned, let's prevent all that signed to unsigned nonsense by doing a
            // bitmask
            final int mid = buffer.get() & 0x000000FF;
            switch(mid) {
                case 0:
                    // grab some bytes from the buffer and change them into a String
                    final byte[] usernameBytes = new byte[SIZE_OF_USER_NAME];
                    buffer.get(usernameBytes);
                    final String username = new String( usernameBytes, Charset.forName(StandardCharsets.UTF_8.name()));
                    // ...
                    break;
                case 1:
                    // grab 4 bytes from the buffer and change it into an integer
                    final int roomId = buffer.getInt();
                    // ...
                    break;
                default:
                    // ...
            }
        } catch(IOException ioe) {
            // TODO: handle exception
        }
    }

}