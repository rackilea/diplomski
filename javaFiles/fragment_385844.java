char[] buffer = new char[1000];
StringBuilder sb = new StringBuilder();
int count;
// note this loop condition
while((count = reader.read(buffer)) != -1) {
    sb.append(buffer, 0, count);
}
String input = sb.toString();