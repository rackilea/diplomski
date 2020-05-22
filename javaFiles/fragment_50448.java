import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ComputerServer
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket serverSocket;
        Socket connection;

        serverSocket = new ServerSocket(8000);
        int clientNo = 1;
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        while (true)// runs indefinitely
        {
            System.out.println("Waiting for client");
            connection = serverSocket.accept();
            System.out.println("Client connected: " + connection.getPort());
            HandleAClient thread = new HandleAClient(connection, clientNo);
            threadExecutor.execute(thread);
            clientNo++;
        }
    }
}

class HandleAClient implements Runnable
{
    ObjectOutputStream output;
    ObjectInputStream input;
    ServerSocket serverSocket;

    int clientNo;

    public HandleAClient(Socket connection, int clientNo)
    {
        this.clientNo = clientNo;
        try
        {
            this.input = new ObjectInputStream(connection.getInputStream());
            this.output = new ObjectOutputStream(connection.getOutputStream());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Object obj = input.readObject();

                System.out.println("\nObject Received from Client:\n" + obj);

                if (obj instanceof Computer)
                {
                    Computer c = (Computer) obj;
                    double totalCharge = c.price * c.quantity;
                    System.out.format("\nTotal Charge[%d]\t%f", clientNo,
                            totalCharge);
                    output.writeObject(totalCharge);
                    output.flush();
                }
            } catch (Exception e) { //JUST FOR BREVITY
                e.printStackTrace();
            }
        }
    }
}