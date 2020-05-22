byte [] mask = { (byte)255, 0, 0, 0 };
byte[] addrBytes = InetAddress.getByName("126.5.6.7").getAddress();
for (int i=0; i < 4; i++) {
  addrBytes[i] |= ((byte)0xFF) ^ mask[i];
}
InetAddress bcastAddr = InetAddress.getByAddress(addrBytes);