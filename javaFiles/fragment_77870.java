private static Socket socket = null;
private static ObjectOutputStream oos;
private static ObjectInputStream ois;

// snip ...

public static void getVariables()
{
    try
    {
       ois = new ObjectInputStream(socket.getInputStream());
       Display.variables = (Variables) ois.readObject();
       ois.close();
    }
    catch(IOException i)
    {
       i.printStackTrace();
       return;
    }
    catch(ClassNotFoundException c)
    {
       System.out.println("Variables class not found");
       c.printStackTrace();
       return;
    }
}