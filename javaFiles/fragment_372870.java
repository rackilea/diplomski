String s = "word w'ord wo'rd";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("\\b(\\w)(\\w*)'(\\w(?:'\\w)*)").matcher(s);
while (m.find()) {
    m.appendReplacement(result, 
        m.group(1).toUpperCase()+m.group(2) + "'" + m.group(3).toUpperCase());
}
m.appendTail(result);
System.out.println(result.toString());
// => word W'Ord Wo'Rd