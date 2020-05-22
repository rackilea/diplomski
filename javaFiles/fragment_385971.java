List<String> list = r.iterateRSSFeed();
StringBuilder b = new StringBuilder();
b.append("<html><ul>");
for(String s : list) {
   b.append("<li>");
   b.append(s);
   b.append("</li>");
}
b.append("</ul>");
String description = b.toString();