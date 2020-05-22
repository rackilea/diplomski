import java.net.*;
import java.io.*;

public class Client {

    static String FILE_DIR = "./";

    public static void main(String[] s) throws IOException {

        /**
         * Establish socket using main args.
         */
        String address = s[0];

        while (true) {

            /**
             * Get the file name from the user.
             */
            System.out.print("Insert filename to download: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = null;
            try {
                fileName = reader.readLine();
            } catch (IOException ioe) {
                System.out.println("Eingabe konnte nicht verarbeitet werden!");
                System.exit(1);
            }
            System.out.println("Eingabe: " + fileName);

            /**
             * Create the socket.
             */
            Socket socket = new Socket(address, 12345);

            /**
             * With file name in hand, proceed to send the filename to the
             * server.
             */
            //...put in try-with-resources to close the outputstream.
            try (BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {
                System.out.println("Connected:  Sending file name to server.");
                //...send file name plus a newline.
                bos.write((fileName + '\n').getBytes());
                bos.flush();

            /**
             * Get the file contents and save to disk.
             */
            //...wrap input stream in DataInpuStream for portability.
            //...put in try-with-resource to close the input stream.
            try (BufferedInputStream bis = new BufferedInputStream(new DataInputStream(socket.getInputStream()))) {
                DataOutputStream fos = new DataOutputStream(new FileOutputStream(fileName));
                int n;
                byte[] buffer = new byte[8192];
                System.out.println("Connected:  Recieving file contents from server.");
                while ((n = bis.read(buffer)) > 0) {
                    System.out.println("received " + n + " bytes");
                    fos.write(buffer, 0, n);
                    fos.flush();
                }
                System.out.println("recieved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
     }
    }
}