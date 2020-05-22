String subject = "audio*2012*.wav";
Pattern regex = Pattern.compile("[^*]+|(\\*)");
Matcher m = regex.matcher(subject);
StringBuffer b= new StringBuffer();
while (m.find()) {
    if(m.group(1) != null) m.appendReplacement(b, ".*");
    else m.appendReplacement(b, "\\\\Q" + m.group(0) + "\\\\E");
}
m.appendTail(b);
String replaced = b.toString();
System.out.println(replaced);