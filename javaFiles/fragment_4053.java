String text = "This is my first java Program. I am new to java program. but my program is successfully running without any. issues. Thanks to all";
Pattern pattern = Pattern.compile("(?<=\\.)\\s+(?=[A-Z])");
String[] lines = pattern.split(text);
for (String line : lines) {
    System.out.println(line);
}