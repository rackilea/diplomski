private static String decryptString(String en) {
  if (en == null) {
    return "";
  }
  en = en.trim().toLowerCase();
  StringBuilder sb = new StringBuilder();
  for (char ch : en.toCharArray()) {
    if (ch >= 'a' && ch <= 'j') {
      sb.append((char) ('0' + (ch - 'a')));
    } else {
      sb.append(ch);
    }
  }
  return sb.toString();
}

public static Double decrypt(String encryptedNumber) {
  return Double.valueOf(decryptString(encryptedNumber));
}

public static void main(String[] args) {
  System.out.println(decrypt("ab.a"));
  System.out.println(decrypt("a.jjj"));
}