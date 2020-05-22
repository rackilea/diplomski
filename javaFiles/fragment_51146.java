String line = "Some info about stuff\nNotes: THis is a note about other stuff\nSo is this\n    And this\n\nThis is something else"; 
String pattern = "(?s)Notes.*?(?=\n\n|$)";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);

if (m.find()) {
    System.out.println(m.group());
}