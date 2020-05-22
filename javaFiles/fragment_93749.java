String keyword = "ale";
String rx = "\\w+\\s+\\w*" + keyword;
Pattern p = Pattern.compile(rx);
Matcher matcher = p.matcher("Golden pale ale by @KonaBrewingCo @ Hold Fast Bar");
if (matcher.find()) {
    System.out.println(matcher.group(0)); // => Golden pale
}