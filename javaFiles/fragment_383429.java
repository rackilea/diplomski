final Enumeration<NetworkInterface> netifs = NetworkInterface.getNetworkInterfaces();

        // hostname is passed to your method
        InetAddress myAddr = InetAddress.getByName(hostname);   


        while (netifs.hasMoreElements()) {
            NetworkInterface networkInterface = netifs.nextElement();
            Enumeration<InetAddress> inAddrs = networkInterface.getInetAddresses();
            while (inAddrs.hasMoreElements()) {
                InetAddress inAddr = inAddrs.nextElement();
                if (inAddr.equals(myAddr)) {
                    return networkInterface.getName();
                }


        }