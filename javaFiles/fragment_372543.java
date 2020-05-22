String line = "hi Tom how are you.hey Andy its nice to see you.where is your wife Tom.";

String pattern = "[\\w\\s]*Tom[\\w\\s]*[\\.]?";

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

while (m.find()) {
    System.out.println("Find: " + m.group(0));
}