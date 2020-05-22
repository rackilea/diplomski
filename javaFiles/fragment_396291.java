String input = "hello byte world";

Pattern p = Pattern.compile("(\\w+) (\\w+) (\\w+)");
Matcher m = p.matcher(input);

StringBuffer sb = new StringBuffer();
while (m.find()) {

    // Compute replacement for middle word
    String w = m.group(2);
    String s = w.equals("byte") ? "<A BYTE!>"
             : w.equals("word") ? "<A WORD!>"
             : "something else";

    m.appendReplacement(sb, "$1 " + s + " $3");
}
m.appendTail(sb);
System.out.println(sb);