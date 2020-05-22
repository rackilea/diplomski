String value = "1.9m";
Pattern pattern = Pattern.compile("\\d+([.]\\d+)?");

Matcher matcher = pattern.matcher(value);
String match = null;

while (matcher.find()) {

    int startIndex = matcher.start();
    int endIndex = matcher.end();

    match = matcher.group();
    break;

}

System.out.println(match);