final String regex = "(?<!\\.)\\d+(?:\\.\\d{2})?";
final String string = "3850.439.00 0.00 260.00 23";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
}