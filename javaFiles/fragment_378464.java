class sentMessage implements Runnable
{
  @Override
  public void run()
  {
    try
    {

        //InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
        //serverAddr.getByName(serverIpAddress);
       // socket = new Socket(serverAddr, 502);

       // os = new DataOutputStream(socket.getOutputStream());
        str = smessage.getText().toString();
        str = str + "\n";
        msg = msg + "Client : " + str;
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                chat.setText(msg);
            }
        });
        os.writeBytes(str);
        os.flush();
        //os.close();
        }
    catch(IOException e)
    {
    }
}
}