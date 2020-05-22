final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
while (e.hasMoreElements()) {
    final Iterator<InterfaceAddress> e2 = e.nextElement().getInterfaceAddresses().iterator();
    while (e2.hasNext()) {
        final InetAddress ip = e2.next().getAddress();
        if (ip.isLoopbackAddress() || ip instanceof Inet4Address){
            continue;
        }
        return true;
    }
}
return false;