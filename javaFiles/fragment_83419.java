String data = "some cool color #12eedd more cool colors #4567aa";
StringBuffer sb = new StringBuffer();

Pattern p = Pattern.compile("#[0-9a-f]{3,6}", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(data);
int i = 1;
while (m.find()) {
    m.appendReplacement(sb, "#{" + i++ + "}");
}
m.appendTail(sb);//in case there is some text left after last match

String replaced = sb.toString();
System.out.println(replaced);