public static String getNetworkInformation(NetworkInterface netint) throws SocketException {
    Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
    StringJoiner joiner = new StringJoiner(",");
    while(inetAddresses.hasMoreElements()) {
        InetAddress inetAddress = inetAddresses.nextElement();
        joiner.add(inetAddress.toString());
    }
    return joiner.toString();
}