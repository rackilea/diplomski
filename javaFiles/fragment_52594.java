try
{
    ServerSocket server = new ServerSocket(1234, 5, InetAddress.getLocalHost());
} catch (IOException e)
{
    // handle exception
}