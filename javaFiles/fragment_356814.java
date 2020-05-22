public static void main ( String [] args ) throws UnknownHostException
{
    // Instantiate your own InetAddress object.
    InetAddress address = InetAddress.getLocalHost(); 
    String hostIP = address.getHostAddress() ;
    String hostName = address.getHostName();
    System.out.println( "IP: " + hostIP + "\n" + "Name: " + hostName);
}