String a = "sin(23)+cos(4)+2!+3!+44!";

Pattern pattern = Pattern.compile("\\d+!"); //import java.util.regex.Pattern
Matcher matcher = pattern.matcher(a);       //import java.util.regex.Matcher
while (matcher.find()) {
    System.out.print("Start index: " + matcher.start());
    System.out.print(" End index: " + matcher.end() + " -> ");
    System.out.println(matcher.group());
}