java.net.URL url = new java.net.URL("http://www.joe90.com/showroom");
String tokens[] = url.getHostname().split(".");
StringBuilder sb = new StringBuilder();
for (int i=0; i<tokens.length; i++) {
  if (i > 1) {
    sb.append('.');
  }
  sb.append(tokens[i]);
}
String namespace = sb.toString();