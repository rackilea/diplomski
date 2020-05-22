BInteger write(BigInteger val) {
    BInteger.Builder builder = BInteger.newBuilder();
    ByteString bytes = ByteString.copyFrom(val.toByteArray());
    builder.setValue(bytes);
    return builder.build();
  }

  BigInteger read(BInteger message) {
    ByteString bytes = message.getValue();
    return new BigInteger(bytes.toByteArray());
  }