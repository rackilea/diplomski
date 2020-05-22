String name = ...;
if(name.contains(">")) {
  return false;
}
String xmlDoc = "<" + name + "/>";
DocumentBuilder db = ...;
db.parse(new InputSource(new StringReader(xmlDoc)));