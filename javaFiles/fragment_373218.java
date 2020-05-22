public static byte[] encode(RSAPublicKey key)
  throws IOException
{
  ByteArrayOutputStream buf = new ByteArrayOutputStream();
  byte[] name = "ssh-rsa".getBytes("US-ASCII");
  write(name, buf);
  write(key.getPublicExponent().toByteArray(), buf);
  write(key.getModulus().toByteArray(), buf);
  return buf.toByteArray();
}

private static void write(byte[] str, OutputStream os)
  throws IOException
{
  for (int shift = 24; shift >= 0; shift -= 8)
    os.write((str.length >>> shift) & 0xFF);
  os.write(str);
}