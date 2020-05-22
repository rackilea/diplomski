StringBuffer decodedInput = new StringBuffer();
Matcher match = Pattern.compile("\\\\u([0-9a-fA-F]{4})| ").matcher(input);
while (match.find()) {
  String character = match.group(1);
  if (character == null)
    decodedInput.append(match.group());
  else
    decodedInput.append((char)Integer.parseInt(character, 16));
}