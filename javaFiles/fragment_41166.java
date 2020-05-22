String s = "\"envelopeId\": \"fsadjhfkhdsgf\", \"ashgjkadsagagsalkjghsag\": \"gsajgks\", \"envelopeId\": \"fsadjhfkhdsgfgsd\", \"afshdj\":\"gas\"";
String key = "envelopeId";
Pattern pattern = Pattern.compile("\"" + Pattern.quote(key) + "\":\\s*\"([^\"]+)\"");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1)); 
}