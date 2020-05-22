StringBuilder sb = new StringBuilder(input);
Pattern pattern = Pattern.compile("\\s\\w");
Matcher matcher = pattern.matcher(s);
int pos = 0;
while (matcher.find(pos)) {
    String replacement = matcher.group().substring(1).toUpperCase();
    pos = matcher.start();
    sb.replace(pos, pos + 2, replacement);
    pos += 1;
}
output = sb.toString();