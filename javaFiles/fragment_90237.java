Pattern CURLY_DELIMITER_REGEX = Pattern.compile("\\{(\\w+)\\}");
String messages = "Dear {GUEST_TITLE} {GUEST_FIRST_NAME} {GUEST_LAST_NAME}, Your reservation no {RESERVATION_NUMBER}";
Matcher matcher = CURLY_DELIMITER_REGEX.matcher(messages);
while (matcher.find()) {
    String value = matcher.group(1);
    System.out.println(value);
}