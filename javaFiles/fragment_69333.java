public boolean isLocalAddress(String domain) {
    try {
        InetAddress address = InetAddress.getByName(domain);
        return address.isAnyLocalAddress()
                || address.isLoopbackAddress()
                || NetworkInterface.getByInetAddress(address) != null;
    } catch (UnknownHostException | SocketException e) {
        // ignore
    }
    return false;
}