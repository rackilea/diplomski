String txt = "this is a String ${AUTO_TEST_f} body ${GLOBAL_SYNC} ${AUTO_2}";
String regex = "\\$\\{(AUTO|GLOBAL)_(.*?)\\}";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(txt);
while (matcher.find()) {
    System.out.println(matcher.group() + "\t->\t" + matcher.group(2) + "\t(" + matcher.group(1) + ")" );
}