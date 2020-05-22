String text = "The CLEVER fox JUMPED OVER the big wall in the night.";
String regex = "(\\b[A-Z]+\\s)(?!.*\\b[A-Z]+\\b)(.+?)(\\sin)";
Matcher m = Pattern.compile(regex).matcher(text);
if (m.find()) {
    System.out.println(m.group(2));
}