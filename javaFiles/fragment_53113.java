public void sendCommand(final String command)
{
    if(myLocalSession != null && myLocalSession.isConnected())
    {
        try {
            toChannel.println(command);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}