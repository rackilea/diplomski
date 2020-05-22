InetAddress address = InetAddress.getByName(ip);
if (address instanceof Inet6Address) {
    // It's ipv6
} else if (address instanceof Inet4Address) {
    // It's ipv4
}