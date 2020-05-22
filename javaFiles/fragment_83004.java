public class TestThread
{
    public static void main(String[] args)
    {
        new ConnectionDispatcher(8080).start();
        new CommandProcessor().start();
    }
}
class ConnectionDispatcher extends Thread{
    private int port;
    private OutputStream outputStreams;

    ConnectionDispatcher(int port)
    {
        this.port = port;
    }

    @Override
    public void run()
    {
        try
        {
            listen(port);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void listen(int port) throws IOException
    {
        //Initialize the ServerSocket
        ss = new ServerSocket(port);
        System.out.println("Listening on " + InetAddress.getLocalHost() + ":" + ss.getLocalPort());

        boolean running = true;

        //Keep accepting connections
        while (running) {
            //Get the incoming connection
            Socket s = ss.accept();
            System.out.println("Connection from: " + getFullIP(s));

            //Create a DataOutputStream for writing data to the other side
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());

            //Save this stream so I don't have to make it again
            outputStreams.put(s, dataOut);

            //Create a new thread for this connection
            new ServerThread(this, s);

        }
    }
}

class CommandProcessor extends Thread{
    @Override
    public void run()
    {
        Scanner cmdScanner = new Scanner(System.in);
        String command = cmdScanner.next();
        processCommand(command);
    }
}