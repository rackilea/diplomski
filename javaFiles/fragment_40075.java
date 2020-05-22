static boolean isInetAddressOrBlock(String address) {
  int slash = address.lastIndexOf('/');
  if (slash != -1) {
    address = address.substring(0, slash);
  }
  return InetAddresses.isInetAddress(address);
}