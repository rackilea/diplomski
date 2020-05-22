StringBuilder sb = new StringBuilder();
for (String p : path) { // Might cost a bit of speed.
    sb.append(p).append('{');
}
sb.append(string);
for (int i = 0; i < path.length; ++i) {
    sb.append('}');
}
String writer = sb.toString();