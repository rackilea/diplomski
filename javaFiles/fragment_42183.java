String html = ...;
String search = "Comment EC12:";
int comment = html.indexOf(search);
if (comment != -1) {
  int start = comment + search.length();
  int end = start + ...;
  String after = html.substring(start, end);
  ...
}