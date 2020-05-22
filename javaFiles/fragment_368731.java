int timeout = 2000;
  InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
  for (InetAddress address : addresses) {
    if (address.isReachable(timeout))
      System.out.printf("%s is reachable%n", address);
    else
      System.out.printf("%s could not be contacted%n", address);
  }