String input = "Phone number (714) 321-2620 just texted about property 690 Warwick Avenue (679871)";
Matcher m = Pattern.compile("^Phone number (.*) just texted about property (.*)$").matcher(input);
if(m.find()) {
  String first = m.group(1); // (714) 321-2620
  String second = m.group(2); // 690 Warwick Avenue (679871)
  // use the two values
}