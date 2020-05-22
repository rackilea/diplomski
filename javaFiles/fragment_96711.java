public static byte[] transcodeField(byte[] source, Charset from, Charset to) {
  byte[] result = new String(source, from).getBytes(to);
  if (result.length != source.length) {
    throw new AssertionError(result.length + "!=" + source.length);
  }
  return result;
}