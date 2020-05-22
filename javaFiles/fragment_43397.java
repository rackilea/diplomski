import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ServerCommunicationThread extends Thread {

    public final static int TCP_SERVER_PORT = 13337;

    private ArrayList<String> mMessages = new ArrayList<>();
    private String mServer;

    private boolean mRun = true;

    public ServerCommunicationThread(String server) {
        this.mServer = server;
    }

    @Override
    public void run() {

        while (mRun) {
            Socket s = null;
            try {
                s = new Socket(mServer, TCP_SERVER_PORT);
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

                while (mRun) {
                    String message;

                    // Wait for message
                    synchronized (mMessages) {
                        while (mMessages.isEmpty()) {
                            try {
                                mMessages.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        // Get message and remove from the list
                        message = mMessages.get(0);
                        mMessages.remove(0);
                    }

                    //send output msg
                    String outMsg = message;
                    out.write(outMsg);
                    out.flush();
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //close connection
                if (s != null) {
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void send(String message) {
        synchronized (mMessages) {
            mMessages.add(message);
            mMessages.notify();
        }
    }

    public void close() {
        mRun = false;
    }
}