import java.net.*;
import java.io.*;

public class NetTest {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        /* Open a socket to listen */
        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6000");
            System.exit(-1);
        }

        // Try catch a socket to listen on
        Socket clientSocket = null;
        try {
            System.out.println("Waiting for auth on 6000...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6000");
            System.exit(-1);
        }

        // Now a stream has been opened...
        InputStream in = null;
        OutputStream out = null;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Failed to get streams.");
            System.exit(-1);
        }

        System.out.println("Socket connection incoming!");

        // Keep going while we can...
        byte b[] = new byte[100];
        int offset = 0;
        String s;
        try {
            boolean done = false;
            boolean auth = false;
            String protocol_target = "<policy-file-request/>";
            byte[] p_bytes = protocol_target.getBytes();
            int result;
            while (!done) {
                if (in.read(b, offset, 1) == -1)
                    done = true;
                else {
                    if (!auth) {
                        ++offset;
                        b[offset] = 0;
                        if (offset != p_bytes.length) {
                            System.out.println("Waiting for protocol data... ("
                                    + offset + "/" + p_bytes.length + ")");
                        } else {
                            // Compare byte data
                            for (int i = 0; i < p_bytes.length; ++i) {
                                System.out.print(b[i] + " ");
                            }
                            System.out.print("\n");
                            System.out.flush();
                            for (int i = 0; i < p_bytes.length; ++i) {
                                System.out.print(p_bytes[i] + " ");
                            }
                            System.out.print("\n");
                            System.out.flush();
                            boolean match = true;
                            for (int i = 0; i < p_bytes.length; ++i) {
                                if (b[i] != p_bytes[i]) {
                                    match = false;
                                    System.out
                                            .println("Mismatch on " + i + ".");
                                }
                            }
                            if (match)
                                auth = true;
                            else {
                                System.out.println("Bad protocol input.");
                                System.exit(-1);
                            }
                        }

                        // Auth
                        if (auth) {
                            System.out.println("Authing...");
                            s = "<?xml version=\"1.0\"?><cross-domain-policy><allow-access-from domain='*' to-ports='6000' /></cross-domain-policy>";
                            b = s.getBytes();
                            out.write(b, 0, b.length);
                            b[0] = 0;
                            out.write(b, 0, 1); // End
                            out.flush();
                            offset = 0;
                            b = new byte[100];
                            b[0] = 0;
                            auth = true;
                            System.out.println("Auth completed.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Stream failure: " + e.getMessage());
            System.exit(-1);
        }

        // Finished.
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Failed closing auth stream: " + e.getMessage());
            System.exit(-1);
        }

        // Try catch a socket to listen on for data
        try {
            System.out.println("Waiting on 6000 fo data...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6000");
            System.exit(-1);
        }

        // Now a stream has been opened...
        in = null;
        out = null;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Failed to get streams.");
            System.exit(-1);
        }

        System.out.println("Socket data connection waiting.");

        // Echo
        try {
            boolean done = false;
            while (!done) {
                if (in.read(b, offset, 1) == -1)
                    done = true;
                else {
                    b[1] = 0;
                    s = new String(b);
                    System.out.print(s);
                    System.out.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Failed echo stream: " + e.getMessage());
            System.exit(-1);
        }

        // Finished.
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Failed closing stream: " + e.getMessage());
            System.exit(-1);
        }
    }

}