public static byte[] getMACAddress() throws SocketException, UnknownHostException {
    InetAddress address = InetAddress.getLocalHost();
    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);

    return networkInterface.getHardwareAddress();
}