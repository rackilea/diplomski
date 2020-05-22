String subject = "qwerty <img src=\"image.jpg\"> zxc";
Pattern regex = Pattern.compile("<img[^>]+>|(.)");
Matcher m = regex.matcher(subject);
StringBuffer b= new StringBuffer();
while (m.find()) {
if(m.group(1) != null) m.appendReplacement(b, "");
else m.appendReplacement(b, m.group(0));
}
m.appendTail(b);
String replaced = b.toString();
System.out.println(replaced);