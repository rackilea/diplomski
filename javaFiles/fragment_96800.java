String name = "?tsds?dsds?";

Matcher m=Pattern.compile("?", Pattern.LITERAL).matcher(name);
StringBuffer sb=new StringBuffer();
while(m.find()) {
    m.appendReplacement(sb, String.valueOf(m.start()));
}
m.appendTail(sb);
name=sb.toString();

System.out.println(name);