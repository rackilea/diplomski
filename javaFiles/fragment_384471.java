String introduction="<p>abcde</p><p>pqrs</p><p>xyz</p>";
JSONObject intro_paragraphs = new JSONObject(); 
JSONObject obj=new JSONObject();
Matcher m = Pattern.compile(Pattern.quote("<p>")+ "(.*?)"+  Pattern.quote("</p>")).matcher(introduction);
int i=1;
String key="para_";
while(m.find())
{
    String match_intro = m.group(1);
    intro_paragraphs.put(key+i, match_intro);
    i++;
}
obj.put("Section_Detailed_Introduction", intro_paragraphs);