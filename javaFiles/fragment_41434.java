import java.net.InetAddress;

private boolean isHostReachable(String host)
{
    try
    {
        return InetAddress.getByName(host).isReachable(500);
    }
    catch (IOException e)
    {
        System.out.err("Error while checking if host is reachable: " + host + ", error is: " + e.getMessage());
        return false;
    }
}