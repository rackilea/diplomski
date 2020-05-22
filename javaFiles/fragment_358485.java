String text = "230 computer delete reboot exit";
Pattern p = Pattern.compile("(.*)\\s+(.*)\\s+(.*)\\s+(.*)\\s+(.*)");
Matcher m = p.matcher(text);
if (m.matches()) {
    String first = m.group(1);
    String second = m.group(2);
    ....