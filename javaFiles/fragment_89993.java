Pattern pattern = Pattern.compile("(?:([0-9a-fA-F]{2} ?){6}\r)+");
String string = "01 02 05 0A 2D 3E\r01 02 12 2B 09 07\r"; 

Matcher matcher = pattern.matcher(string);

if (matcher.matches()) {
    System.out.println(matcher.group());
}