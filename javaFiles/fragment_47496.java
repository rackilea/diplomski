String text = "player number 8 have a nice day. the price is 1 000 $ or you have to pay 2000$.";
String regex = "(([0-9]+\\s?)+)\\$";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {                                                
    System.out.println(matcher.group(1));
}