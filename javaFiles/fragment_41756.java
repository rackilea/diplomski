String inputStr = "Hi, Your Mobile no. is: 9876499321. Also, +919876499321 or 919876499321 or 09-876499321.";   
String myregex = "(?<!\\d)\\d{10,14}(?!\\d)";
// Or String myregex = "\\b\\d{10,14}\\b";
Pattern pattern = Pattern.compile(myregex);
Matcher matcher = pattern.matcher(inputStr.replace("-", ""));

while(matcher.find()) {
    System.out.println(matcher.group());
}