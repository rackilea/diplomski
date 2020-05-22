Pattern pattern = Pattern.compile("name: ([^,]+)");
Matcher matcher = pattern.matcher(str.toString());
if (matcher.matches()) {
    System.out.println(matcher.group(0));
    System.out.println(matcher.group(1));
}