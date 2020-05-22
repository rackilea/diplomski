List<NetworkInterface> interfaces;
try {
    interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
    for (NetworkInterface ni : interfaces)
    {
        if ((ni.isLoopback() == false) && ni.isUp() && (ni.getName().equals("wlan0")))
        {

            // enumerate ip addresses on this network interface (e.g. ni.getInetAddresses()

            // return the first one that is is Ipv4

        }
    }