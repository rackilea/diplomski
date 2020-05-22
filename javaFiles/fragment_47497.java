String text = "1000$ and 5 000 EUR and 2 000 , 00 $ and 3000,00 EUR";
//1000,5000,2000,3000
String regex = "(([0-9]+[\\s,]*)+)(\\$|EUR)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println(matcher.group(1).replaceAll("[^0-9]", ""));
    //                                              ^^^^^^--------to get only the degits
}