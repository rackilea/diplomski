import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;


import javax.imageio.ImageIO;

class Server{
    public static void main(String[] args) {
        int PORT_NUMBER = 8888;

        try (
            ServerSocket server = new ServerSocket(PORT_NUMBER);
            Socket client = server.accept();
            OutputStream sout = client.getOutputStream();
            InputStream sin = client.getInputStream();
        ){
            System.out.println("GOT CONNECTION FROM: " + client.getInetAddress().toString());

            // Get length
            byte[] size_buff = new byte[4];
            sin.read(size_buff);
            int size = ByteBuffer.wrap(size_buff).asIntBuffer().get();
            System.out.format("Expecting %d bytes\n", size);

            // Send it back (?)
            sout.write(size_buff);

            // Create Buffers
            byte[] msg_buff = new byte[1024];
            byte[] img_buff = new byte[size];
            int img_offset = 0;
            while(true) {
                int bytes_read = sin.read(msg_buff, 0, msg_buff.length);
                if(bytes_read == -1) { break; }

                // Copy bytes into img_buff
                System.arraycopy(msg_buff, 0, img_buff, img_offset, bytes_read);
                img_offset += bytes_read;
                System.out.format("Read %d / %d bytes...\n", img_offset, size);

                if(img_offset >= size) { break; }
            }
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(img_buff));
            ImageIO.write(image, "jpg", new File("C:\\temp\\test-output.jpg"));

            // Send "OK"
            byte[] OK = new byte[] {0x4F, 0x4B};
            sout.write(OK);
        }
        catch (IOException ioe) { ioe.printStackTrace(); }
    }
}