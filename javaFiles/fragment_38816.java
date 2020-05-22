String INPUT="united states corp";
Pattern p = Pattern.compile("\\b\\p{Ll}");
StringBuffer result = new StringBuffer();
Matcher m = p.matcher(INPUT);
while (m.find()) {
    m.appendReplacement(result, m.group().toUpperCase());
}
m.appendTail(result);
System.out.println(result.toString()); // => United States Corp