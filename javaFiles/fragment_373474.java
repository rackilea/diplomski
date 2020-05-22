String test = "other stuff (0000,0002) foo \n(0000,0003) bar \n(0002,0005)baz";
Pattern pattern = Pattern.compile("[(](\\d{4}),(\\d{4})[)]");
Matcher matcher = pattern.matcher(test);
while (matcher.find()) {
    System.out.println(String.format("(%s,%s)", matcher.group(1), matcher.group(2)));
}