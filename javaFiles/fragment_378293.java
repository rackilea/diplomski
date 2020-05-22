private static final String alfabetohexa = "0123456789ABCDEF";
private static final int    n            = alfabetohexa.length();
private static final Random random       = new Random();
public static String generarMuestras(final int len) {
  StringBuilder sb = new StringBuilder(len);
  for (int i = 0; i < len; i++) {
    sb.append(alfabetohexa.charAt(random.nextInt(n)));
  }
  return sb.toString();
}