try
{
    address = InetAddress.getByName(ipAddr);

    boolean isIPv6 = address instanceof Inet6Address;
    if (isIPv6)
        throw new UnknownHostException("IPv6 Address");

    isIPv4 = address.getHostAddress().equals(ipAddr) && address instanceof Inet4Address;
}