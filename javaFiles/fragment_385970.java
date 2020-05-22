List<String> list = r.iterateRSSFeed();
StringBuilder b = new StringBuilder();
for(String s : list) {
   b.append(s);
}
String description = b.toString();