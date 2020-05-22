String inputLine = "What is the weather in 75042?";
Pattern pattern = Pattern.compile("weather\\D*(\\d+)");
Matcher matcher = pattern.matcher(inputLine);

if (matcher.find()) {
    System.out.println(matcher.group(1)); // => 75042
}