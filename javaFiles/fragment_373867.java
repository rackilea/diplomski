public static byte[] toBytesFromString(String uuid) {
    UUID id = UUID.fromString(uuid);
    final Long msb = id.getMostSignificantBits();
    final Long lsb = id.getLeastSignificantBits();

    return ByteBuffer.allocate(2 * Long.BYTES).putLong(msb).putLong(lsb).array();

  }