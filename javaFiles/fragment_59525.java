byte[] hash = complete.digest();
StringBuilder sb = new StringBuilder();
for (byte b : hash)
  sb.append(String.format("%02x", b & 0xFF));
String hexHash = sb.toString();
System.out.println(hexHash);