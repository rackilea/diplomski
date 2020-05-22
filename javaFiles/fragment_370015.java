Pattern pattern = Pattern.compile("\\?{3}(.*?)\\?{3}");
Matcher m = pattern.matcher(inputString);

while (m.find()) {
    System.out.println(m.group(1));
}