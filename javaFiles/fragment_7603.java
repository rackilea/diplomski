final String input = "<position x=\"1\" y=\"2\" z=\"3\" />";
final String regex = "<position\\sx=\"([0-9]+)\"\\sy=\"([0-9]+)\"\\sz=\"([0-9]+)\"\\s\\/>";
final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(input);
if (matcher.matches()) {
    final String x = matcher.group(1);
    final String y = matcher.group(2);
    final String z = matcher.group(3);
    System.out.println(x + " " + y + " " + z);
}