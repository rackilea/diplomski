public static void main(String[] args) {
  String utf16 = transformString("This is \\xEF\\xBC\\xA1 string");
  for (char ch : utf16.toCharArray()) {
    System.out.format("%s %02x%n", ch, (int) ch);
  }
}

private static final Pattern SEQ 
                           = Pattern.compile("(\\\\x\\p{Alnum}\\p{Alnum})+");

private static String transformString(String encoded) {
  StringBuilder decoded = new StringBuilder();
  Matcher matcher = SEQ.matcher(encoded);
  int last = 0;
  while (matcher.find()) {
    decoded.append(encoded.substring(last, matcher.start()));
    byte[] utf8 = toByteArray(encoded.substring(matcher.start(), matcher.end()));
    decoded.append(new String(utf8, Charset.forName("UTF-8")));
    last = matcher.end();
  }
  return decoded.append(encoded.substring(last, encoded.length())).toString();
}

private static byte[] toByteArray(String hexSequence) {
  byte[] utf8 = new byte[hexSequence.length() / 4];
  for (int i = 0; i < utf8.length; i++) {
    int offset = i * 4;
    String hex = hexSequence.substring(offset + 2, offset + 4);
    utf8[i] = (byte) Integer.parseInt(hex, 16);
  }
  return utf8;
}