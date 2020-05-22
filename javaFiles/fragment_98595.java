Pattern p = Pattern.compile("\\[(.*)\\]\\((.*)\\)");
String input = "[foo](bar)";
Matcher m = p.matcher(input);
if (m.find()){
    String[] a = { m.group(1), m.group(2) }; 
}