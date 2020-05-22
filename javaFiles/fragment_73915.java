String testString = "a\\,b\\\\,c,d\\\\\\,e,f\\\\g";
String[] splitedString = testString
        .split("(?<!(?<!\\\\)\\\\(\\\\{2}){0,1000000000}),");
for (String string : splitedString) {
    System.out.println(string);
}

System.out.println("-----");
Matcher m = Pattern.compile("(\\G.*?(?<!\\\\)(\\\\{2})*)(,|(?<!\\G)$)",
        Pattern.DOTALL).matcher(testString);
while (m.find()) {
    System.out.println(m.group(1));
}

System.out.println("-----");
for (String s : parse(testString))
    System.out.println(s);