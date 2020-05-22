StringBuilder result = new StringBuilder();
Matcher m = pattern.matcher(input);
while(m.find()) {
    String token = m.group();
    result.append(retain.contains(token) ? token : "X");
}