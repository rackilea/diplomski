String input = "random text blah blah <change>hello</change> more random text <change>hey</change> ..";
StringBuffer sb = new StringBuffer();

Pattern p = Pattern.compile("<change>(.*?)</change>",Pattern.DOTALL);
Matcher m = p.matcher(input);

while(m.find()){
    String valueFromTags = m.group(1);
    m.appendReplacement(sb, valueFromTags.toUpperCase());
    //                                    ^^^^^^^^^^^^^
    // you decide what to put as replacement of original value
    // toUpperCase is just example
}
m.appendTail(sb);

String result = sb.toString();
System.out.println(result);