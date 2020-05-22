private static ServerSocket serverSocket;
private static Socket clientSocket;
private static ObjectInputStream ois;
private static ObjectOutputStream oos;

// snip ...

public static void sendVariables()
{
    try
    {
        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
        out.writeObject(Display.variables);
        out.close();
    }
    catch(IOException i)
    {
        i.printStackTrace();
    }
}