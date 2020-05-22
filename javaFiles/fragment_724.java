Map<String, String> dictionary = new HashMap<String, String>();
dictionary.put("ä", "ae");
dictionary.put("ö", "oe");
dictionary.put("ü", "ue");
String s = "<h1 id=\"anwendungsfälle-und--funktionen\">Anwendungsfälle und -funktionen</h1> \n<h1 id=\"öl\">Öl</h1>";
StringBuffer result = new StringBuffer();
Matcher m = Pattern.compile("(\\G(?!^)|<h\\d+\\s+id=\")([^\"]*?)([üöä])").matcher(s);
while (m.find()) {
    m.appendReplacement(result, m.group(1) + m.group(2) + dictionary.get(m.group(3)));
}
m.appendTail(result);
System.out.println(result.toString());
// => <h1 id="anwendungsfaelle-und--funktionen">Anwendungsfälle und -funktionen</h1> 
// <h1 id="oel">Öl</h1>