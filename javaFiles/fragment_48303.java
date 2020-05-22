interfaceName = "eth0";
    NetworkInterface networkInterface = NetworkInterface.getByName(interfaceName);
    Enumeration<InetAddress> inetAddress = networkInterface.getInetAddresses();
    InetAddress currentAddress;
    currentAddress = inetAddress.nextElement();
    while(inetAddress.hasMoreElements())
    {
        currentAddress = inetAddress.nextElement();
        if(currentAddress instanceof Inet4Address && !currentAddress.isLoopbackAddress())
        {
            ip = currentAddress.toString();
            break;
        }
    }