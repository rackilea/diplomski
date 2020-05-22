private static String encode(String num, int x)
{
  StringBuilder sb = new StringBuilder();
  for (char c : num.toCharArray()) {
    sb.append((char) (c + x));
  }
  return sb.toString();
}