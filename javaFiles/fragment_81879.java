private void getPcInfo() {
    Enumeration<?> interfaces = null;
    try {
        PcLogName = InetAddress.getLocalHost().getHostName();
        InetAddress local = InetAddress.getLocalHost();
        InetAddress[] all_local = InetAddress.getAllByName(local.getHostName());
        LinkedList<InetAddress> list = new LinkedList<InetAddress>();
        //System.out.println("PcLogName " + PcLogName);
        //System.out.println("PcLogName " + list);
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
            ////System.out.println("NetworkInterface " + interfaces);
        } catch (SocketException ex) {
            Logger.getLogger(GuiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (interfaces.hasMoreElements()) {
            NetworkInterface card = (NetworkInterface) interfaces.nextElement();
            ////System.out.println("NetworkInterface NetCard " + card);
            Enumeration<?> addresses = card.getInetAddresses();
            ////System.out.println("NetCard Name " + addresses);
            if (addresses == null) {
                continue;
            }
            while (addresses.hasMoreElements()) {
                InetAddress address = (InetAddress) addresses.nextElement();
                list.add(address);
                //System.out.println("Add Address : " + address);
            }
        }
        //System.out.println("IP's Address " + list);
    } catch (UnknownHostException ex) {
        Logger.getLogger(GuiFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    PcLogUser = System.getProperty("user.name");
    //System.out.println("PcLogUser : " + PcLogUser);
    WinUser = System.getenv("USER");
    //System.out.println("WinUser : " + WinUser);
    WinDsn = System.getenv("USERDOMAIN");
    //System.out.println("WinDsn : " + WinDsn);
    WinUserName = System.getenv("USERNAME");
    //System.out.println("WinUserName : " + WinUserName);
    WinPath = System.getenv("USERPROFILE");
    //System.out.println("WinPath : " + WinPath);
    ComputerName = System.getenv("COMPUTERNAME");
    //System.out.println("ComputerName : " + ComputerName);
    PcInfo = System.getenv("System Model");
    //System.out.println("PcInfo : " + PcInfo);        
}