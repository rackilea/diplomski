char ch = line.charAt(i);

if (from.contains(ch)) {
    char c = to.charAt(from.indexOf(ch));
    outPutText += c;
}