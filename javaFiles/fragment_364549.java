JSONObject o = new JSONObject(
jsonString.replaceFirst("result", "\"result\"")
.replaceAll("\"\\{", "{")
.replaceAll("\\}\"", "}")
.replaceAll("\\\\\"", "\"") );
String xml = org.json.XML.toString(o);