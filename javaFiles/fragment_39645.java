import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ApplicationInstanceManager {

    private static final boolean DEBUG = false;

    private static ApplicationInstanceListener subListener;

    /** Randomly chosen, but static, high socket number */
    public static final int SINGLE_INSTANCE_NETWORK_SOCKET = 44331;

    /** Must end with newline */
    public static final String SINGLE_INSTANCE_SHARED_KEY = "$$RabidNewInstance$$\n";

    /**
     * Registers this instance of the application.
     * 
     * @return true if first instance, false if not.
     */
    public static boolean registerInstance() {
        // returnValueOnError should be true if lenient (allows app to run on
        // network error) or false if strict.
        boolean returnValueOnError = true;
        // try to open network socket
        // if success, listen to socket for new instance message, return true
        // if unable to open, connect to existing and send new instance message,
        // return false
        try {
            final ServerSocket socket = new ServerSocket(
                    SINGLE_INSTANCE_NETWORK_SOCKET, 10, InetAddress
                            .getLocalHost());
            if (DEBUG)
                System.out.println("Listening for application instances on socket "
                    + SINGLE_INSTANCE_NETWORK_SOCKET);
            Thread instanceListenerThread = new InstanceListenerThread(socket);
            instanceListenerThread.start();
            // listen
        } catch (UnknownHostException e) {
            EclipseLogging.logError(RabidPlugin.getDefault(),
                    RabidPlugin.PLUGIN_ID, e);
            return returnValueOnError;
        } catch (IOException e) {
            return portTaken(returnValueOnError, e);

        }
        return true;
    }

    private static boolean portTaken(boolean returnValueOnError, IOException e) {
        if (DEBUG)
            System.out.println("Port is already taken.  "
                    + "Notifying first instance.");
        try {
            Socket clientSocket = new Socket(InetAddress.getLocalHost(),
                    SINGLE_INSTANCE_NETWORK_SOCKET);
            OutputStream out = clientSocket.getOutputStream();
            out.write(SINGLE_INSTANCE_SHARED_KEY.getBytes());
            out.close();
            clientSocket.close();
            System.out.println("Successfully notified first instance.");
            return false;
        } catch (UnknownHostException e1) {
            EclipseLogging.logError(RabidPlugin.getDefault(),
                    RabidPlugin.PLUGIN_ID, e);
            return returnValueOnError;
        } catch (IOException e1) {
            EclipseLogging
                    .logError(
                            RabidPlugin.getDefault(),
                            RabidPlugin.PLUGIN_ID,
                            "Error connecting to local port for single instance notification",
                            e);
            return returnValueOnError;
        }
    }

    public static void setApplicationInstanceListener(
            ApplicationInstanceListener listener) {
        subListener = listener;
    }

    private static void fireNewInstance() {
        if (subListener != null) {
            subListener.newInstanceCreated();
        }
    }

    public static void main(String[] args) {
        if (!ApplicationInstanceManager.registerInstance()) {
            // instance already running.
            System.out.println("Another instance of this application " + 
                    "is already running.  Exiting.");
            System.exit(0);
        }
        ApplicationInstanceManager
                .setApplicationInstanceListener(new ApplicationInstanceListener() {
                    public void newInstanceCreated() {
                        System.out.println("New instance detected...");
                        // this is where your handler code goes...
                    }
                });
    }

    public static class InstanceListenerThread extends Thread {

        private ServerSocket socket;

        public InstanceListenerThread(ServerSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            boolean socketClosed = false;
            while (!socketClosed) {
                if (socket.isClosed()) {
                    socketClosed = true;
                } else {
                    try {
                        Socket client = socket.accept();
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));
                        String message = in.readLine();
                        if (SINGLE_INSTANCE_SHARED_KEY.trim().equals(
                                message.trim())) {
                            if (DEBUG)
                                System.out.println("Shared key matched - "
                                        + "new application instance found");
                            fireNewInstance();
                        }
                        in.close();
                        client.close();
                    } catch (IOException e) {
                        socketClosed = true;
                    }
                }
            }
        }
    }
}