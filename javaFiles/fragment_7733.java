final String regex = "filename=\"(.*?)\";";
final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(<input-string>);

if (matcher.find()) {
    System.out.println("Filename: " + matcher.group(1));
}