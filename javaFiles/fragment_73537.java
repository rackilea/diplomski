String input = "adklsfjb$${xxx}dklsjfnsdklj${yyy}adljfhjh";

Map<String, String> type1 = new HashMap<>();
type1.put("xxx", "[type I with x's]");
type1.put("yyy", "[type I with y's]");

Map<String, String> type2 = new HashMap<>();
type2.put("xxx", "{TYPE 2 WITH x's}");
type2.put("yyy", "{TYPE 2 WITH y's}");

StringBuffer buf = new StringBuffer();
Matcher m = Pattern.compile("(\\$)?\\$\\{([^}]+)}").matcher(input);
while (m.find()) {
    String var = m.group(2);
    String repl = (m.start(1) == -1 ? type1.get(var) : type2.get(var));
    if (repl != null)
        m.appendReplacement(buf, Matcher.quoteReplacement(repl));
}
String output = m.appendTail(buf).toString();

System.out.println(output);