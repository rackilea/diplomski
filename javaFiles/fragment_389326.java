byte[] unpack(int bytes) {
  return new byte[] {
    (byte)((bytes >>> 24) & 0xff),
    (byte)((bytes >>> 16) & 0xff),
    (byte)((bytes >>>  8) & 0xff),
    (byte)((bytes       ) & 0xff)
  };
}


InetAddress.getByAddress(unpack(packedBytes)).getHostAddress()