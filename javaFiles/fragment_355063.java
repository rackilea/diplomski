public static void main(String[] args) throws UnknownHostException, SocketException {
  System.out.println("Current IP address : " + InetAddress.getLocalHost().getHostAddress());

  for(NetworkInterface network : IterableEnumeration.make(NetworkInterface.getNetworkInterfaces())) {
    byte[] mac = network.getHardwareAddress();
    if(mac != null) {
      System.out.print("Current MAC address : ");
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < mac.length; i++) {
        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
      }
      System.out.println(sb.toString());
      //Bound InetAddress for interface
      for(InetAddress address : IterableEnumeration.make(network.getInetAddresses())) {
        System.out.println("\tBound to:"+address.getHostAddress());
      }
    }
  }
}