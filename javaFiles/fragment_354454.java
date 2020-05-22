Pattern p = Pattern.compile("\\bto=([^,]+),"); // remember to double the \ escape
Matcher m = p.matcher(lineInfo.getText());
List<String> list = new ArrayList<>();
while (m.find()) {
    list.add(m.group(1)); // add text in capture group 1 to the list
}
lineInfo.setTo(list);