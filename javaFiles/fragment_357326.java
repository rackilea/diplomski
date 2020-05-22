public static void main(String[] args) throws java.lang.Exception {
    String s = "AZERTY<em>ZA</em> QWERTY OK <em>NE</em>NO";
    String matchedString = null;
    List<String> extractedString = new ArrayList<String>();
    Pattern p = Pattern.compile("\\<em>(.*?)\\</em>");
    Matcher m = p.matcher(s);
    StringBuffer sb = new StringBuffer();

    while (m.find()) {

        matchedString = m.group(1);
        extractedString.add(matchedString);
        m.appendReplacement(sb, matchedString);
        sb.append(" ");

    }
    m.appendTail(sb);

    System.out.println(sb.toString());
    System.out.println(extractedString.toString());
}
Output :
String buffer = AZERTYZA  QWERTY OK NE NO
List of extracted String = [ZA, NE]