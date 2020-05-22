Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

while (interfaces.hasMoreElements())
{
NetworkInterface networkInterface = interfaces.nextElement();

Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

}
}