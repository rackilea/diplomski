java.util.Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
        en.hasMoreElements(); ) {
        NetworkInterface iface = en.nextElement();
        List<InterfaceAddress> addrs = iface.getInterfaceAddresses();
        //For each network interfaces iterate through each ip address
        for(InterfaceAddress addr : addrs) {
                         ip = addr.getAddress();
                          //Process the IP ...