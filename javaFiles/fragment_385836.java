public static byte[] xor(byte[] a, byte[] b) {
  byte[] result = new byte[Math.min(a.length, b.length)];

  for (int i = 0; i < result.length; i++) {
    result[i] = (byte) (((int) a[i]) ^ ((int) b[i]));
  }

  return result;
}