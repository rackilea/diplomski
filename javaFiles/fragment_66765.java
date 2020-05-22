boolean scanning=true;
while(scanning)
{
    try
    {
        socketChannel.open(hostname, port);
        scanning=false;
    }
    catch(ConnectionException e)
    {
        System.out.println("Connect failed, waiting and trying again");
        try
        {
            Thread.sleep(2000);//2 seconds
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
    } 
}