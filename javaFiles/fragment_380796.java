Thread t = new Thread(){
public void run()
{
    for(;;)
    {
        String s = null;
    try 
        {
        s = dis.readUTF();
    } 
        catch (IOException e) 
        {
        e.printStackTrace();
        }
        while(s!=null)
        {
            System.out.println("Output: " + s);
        try 
        {
        s = dis.readUTF();
    } 
        catch (IOException e) 
        {
        e.printStackTrace();
    }
    }}}};
   t.start();