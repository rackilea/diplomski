String parameter = "sum(12),sum(3,34,23),122";
Pattern pattern = Pattern.compile("(sum\\(.*?\\)|[0-9]+)");//
Matcher matcher = pattern.matcher(parameter);
while (matcher.find()) {
    System.out.println("match: " + matcher.group(1));
}