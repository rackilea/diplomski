String html = ...;
String[] parts = html.split("\\p{Space}*<br>\\p{Space}*")
for (int i = 0; i < parts.length; i += 2) {
  String search = parts[i];
  String after = parts[i + 1];
  System.out.println(search + "\n\t" + after);
}