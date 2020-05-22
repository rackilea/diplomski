String line = "rule \"My Rule Description Looks Like This\"\n";
line += "followed by some white space other characters such as quotes\".";
String pattern = "rule\\s+\"(.*?)\".*";

Pattern r = Pattern.compile(pattern, Pattern.DOTALL);
Matcher m = r.matcher(line);
if (m.find()) {
   System.out.println("Found a rule: " + m.group(1) );
} else {
   System.out.println("Could not find a rule.");
}