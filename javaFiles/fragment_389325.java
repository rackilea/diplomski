int pack(byte[] bytes) {
  int val = 0;
  for (int i = 0; i < bytes.length; i++) {
    val <<= 8;
    val |= bytes[i] & 0xff;
  }
  return val;
}

pack(InetAddress.getByName(dottedString).getAddress());