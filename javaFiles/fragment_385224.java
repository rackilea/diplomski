String line = "ahref=https://blabla.com/Securities_regulation_in_the_United_States>Securities regulation in the United States</a> - Securities regulation in the United States is the field of U.S. law that covers transactions and other dealings with securities.";

Pattern pattern = Pattern.compile("(?s)(?:^|>)(.*?)(?:<|$)");
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println("group 1: " + matcher.group(1));
}