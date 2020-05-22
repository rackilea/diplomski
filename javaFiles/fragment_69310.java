String input = "2 ltr. btl., select   varieties when you buy 6 $1.25 ea.-50¢  MIX OR MATCH";
Pattern pattern = Pattern.compile(
      "(?x)\\d+(?:\\.\\d+)?\\s+"
    + "  (?:"
    + "     (?:fl )?oz(?:\\.|\\b)|lbs?(?:\\.|\\b)|kg(?:\\.|\\b)|kg?\\b|g(?:\\.|\\b)"
    + "   | pc?k(?:\\.|\\b)|ea(?:\\.|\\b)|ml(?:\\.|\\b)|[cq]t(?:\\.|\\b)"
    + "   | liter\\b|ltr(?:\\.|\\b)"
    + "  )"
);
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {
    System.out.println(matcher.group());
}