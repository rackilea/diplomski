public static NetworkInterface getCurrentInterface() throws SocketException, UnknownHostException {
    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    InetAddress myAddr = InetAddress.getLocalHost();
    while (interfaces.hasMoreElements()) {
        NetworkInterface face = interfaces.nextElement();

        if (Collections.list(face.getInetAddresses()).contains(myAddr))
            return face;
    }
    return null;
}