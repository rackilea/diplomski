StringBuilder sb = new StringBuilder(string);
for (int i = path.length - 1; i >= 0; --i) {
    sb.insert(0, '{');
    sb.insert(0, path[i]);
    sb.append('}');
}
String writer = sb.toString();