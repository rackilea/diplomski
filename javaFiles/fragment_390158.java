String text = "Your Day Traffic is 150 MB and your Night Traffic is 136 MB ";
String regex = "((\\d+)\\sMB)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);
int group = 1;
while (matcher.find()) {
    System.out.println("group " + group++ + " ==> " + matcher.group(2));
}