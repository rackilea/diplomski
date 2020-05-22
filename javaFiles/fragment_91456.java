String src = "This\tis\ta\ttest";
System.out.println("src=\"" + src + '"'); // --> prints "This is a test"
String re="\\t";
System.out.println("re=\"" + re + '"'); // --> prints "\t" - as when you use reSource.getText();

Pattern p = Pattern.compile(re);
Matcher m = p.matcher(src);
while (m.find()) {
    System.out.println('"' + m.group() + '"');
}