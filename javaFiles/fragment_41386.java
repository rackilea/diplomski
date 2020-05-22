class Encoder {
  public static final int BASE = 40;
  StringBuilder chars = new StringBuilder(BASE);
  byte[] index = new byte[256];

  {
    chars.append('\0');
    for (char ch = 'a'; ch <= 'z'; ch++) chars.append(ch);
    for (char ch = '0'; ch <= '9'; ch++) chars.append(ch);
    chars.append("-:.");
    Arrays.fill(index, (byte) -1);
    for (byte i = 0; i < chars.length(); i++)
      index[chars.charAt(i)] = i;
  }

  public byte[] encode(String address) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      for (int i = 0; i < address.length(); i += 3) {
        switch (Math.min(3, address.length() - i)) {
          case 1: // last one.
            byte b = index[address.charAt(i)];
            dos.writeByte(b);
            break;

          case 2:
            char ch = (char) ((index[address.charAt(i+1)]) * 40 + index[address.charAt(i)]);
            dos.writeChar(ch);
            break;

          case 3:
            char ch2 = (char) ((index[address.charAt(i+2)] * 40 + index[address.charAt(i + 1)]) * 40 + index[address.charAt(i)]);
            dos.writeChar(ch2);
            break;
        }
      }
      return baos.toByteArray();
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  public static void main(String[] args) {
    Encoder encoder = new Encoder();
    for (String s : "twitter.com:2122,123.211.80.4:2122,my-domain.se:2121,www.stackoverflow.com:80".split(",")) {
      System.out.println(s + " (" + s.length() + " chars) encoded is " + encoder.encode(s).length + " bytes.");
    }
  }
}