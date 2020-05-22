String processed="";
Pattern pattern = Pattern.compile("\"(?:[^\"]*)\"|<(?:.*?)>");
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    processed += matcher.group(0);
    processed += " ";
}