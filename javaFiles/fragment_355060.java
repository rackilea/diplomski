public static void main(String[] args) {
  try {
    InetAddress ip = InetAddress.getLocalHost();
    System.out.println("Current IP address : " + ip.getHostAddress());

    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
    while(networks.hasMoreElements()) {
      NetworkInterface network = networks.nextElement();
      byte[] mac = network.getHardwareAddress();

      if(mac != null) {
        System.out.print("Current MAC address : ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println(sb.toString());
      }
    }
  } catch (UnknownHostException e) {
    e.printStackTrace();
  } catch (SocketException e){
    e.printStackTrace();
  }
}