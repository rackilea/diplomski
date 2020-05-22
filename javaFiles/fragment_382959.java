String regEx = "(lib/)(.*)\\.js$";
String str = "src/main/lib/abc/DocumentHandler.js";

Pattern pattern = Pattern.compile(regEx);
Matcher matcher = pattern.matcher(str);

if (matcher.find()) { // <== returns true if found            
    System.out.println("Matches: " + matcher.group());
    System.out.println("Path: " + matcher.group(2));
}