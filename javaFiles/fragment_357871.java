byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};
StringBuilder sb = new StringBuilder();
for (byte b : byteArray) {
  sb.append(b);
  sb.append(",");
}
sb.deleteCharAt(sb.length() - 1);
System.out.println(sb);