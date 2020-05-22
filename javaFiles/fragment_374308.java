String regex = "ipsum";
String sourceString = "lorem ipsum dolor sit";

Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(sourceString);
StringBuffer sb = new StringBuffer();

while (m.find()) {
    // For example: transform match to upper case
    String replacement = m.group().toUpperCase();
    m.appendReplacement(sb, replacement);
}

m.appendTail(sb);

sourceString = sb.toString();

System.out.println(sourceString); // "lorem IPSUM dolor sit"