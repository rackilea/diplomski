Pattern pattern = Pattern.compile("PackageName=(.*)");
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    String packageName = matcher.group(1);
    System.out.println(packageName);
}