String input = "...";
Matcher matcher = Pattern.compile("-LSB-,\\s(\\d),\\s-RSB-,").matcher(input);

while (matcher.find()) {
    System.out.println(matcher.group(1));
    // the real work should go here
}