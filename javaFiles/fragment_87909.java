StringBuilder sb = new StringBuilder();
int charsRead;
while ((charsRead = n.read(cbuf)) != -1) {
    sb.append(cbuf, 0, charsRead);
}
inputLine = sb.toString();