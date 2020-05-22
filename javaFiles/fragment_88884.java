Pattern p = Pattern.compile("([A-Z]\\d+)");
Matcher m = p.matcher(str);
while (m.find()) {
    String place = m.group(1);
    // A12, W28 etc is here
}