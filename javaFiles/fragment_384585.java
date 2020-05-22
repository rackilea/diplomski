Socket socket2;
ObjectOutputStream out2 = null;
public void mainMethod()
{
    try
    {
        socket2 = new Socket(serverAddress, 8080);  
        out2 = new ObjectOutputStream(socket2.getOutputStream());
        boolean canSend = true;
        while (canSend)
        {
            canSend = Client_Handler("authentication","user");
        }
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
    finally
    {
        if (out2!=null)
        {
            try
            {
                out2.close();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
public boolean Client_Handler(String auth, String user)
{
    try
    {
        User_Authorization us3 = new User_Authorization();
        us3.set_name(user);
        us3.set_authorization(auth);
        out2.writeUnshared(us3);  
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }  
    return true;
}