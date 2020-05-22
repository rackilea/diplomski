int addressType = InetAddress.getAddressType(address);
InetAddress ia = null;
switch (addressType) {
    case V4 : 
        ia = new Inet4Address();
        break;
    case V6 : 
        ia = new Inet6Address();
        break;
    default :
        throw new RuntimeException("bad address");
}