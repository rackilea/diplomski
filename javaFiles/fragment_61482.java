public ByteString toByteString() {
  try {
    final ByteString.CodedBuilder out =
      ByteString.newCodedBuilder(getSerializedSize());
    writeTo(out.getCodedOutput());
    return out.build();
  } catch (IOException e) {
    throw new RuntimeException(
      "Serializing to a ByteString threw an IOException (should " +
      "never happen).", e);
  }
}

public byte[] toByteArray() {
  try {
    final byte[] result = new byte[getSerializedSize()];
    final CodedOutputStream output = CodedOutputStream.newInstance(result);
    writeTo(output);
    output.checkNoSpaceLeft();
    return result;
  } catch (IOException e) {
    throw new RuntimeException(
      "Serializing to a byte array threw an IOException " +
      "(should never happen).", e);
  }
}