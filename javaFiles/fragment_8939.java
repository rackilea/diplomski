String s = "233<C:\\Users\\Grapes\\Documents\\title.png>233<C:\\Users\\Grapes\\Documents\\title.png>33";
int k = 0;
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("<[^<>]*>").matcher(s);
while (m.find()) {
    m.appendReplacement(result, "<" + ++k + ">");
}
m.appendTail(result);
System.out.println(result.toString());
// => 233<1>233<2>33