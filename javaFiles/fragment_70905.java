String origStr = ...;
StringBuilder sb = new StringBuilder();
for (int i = 0; i < origStr.length(); i++) {
  char ch = origStr.charAt(i);
  sb.append(ch);
  if (ch != ' ' && (i % 2 == 1)) {
    sb.append(' ');
  }
}
String result = sb.toString();