JsonArray finalResult = null;
JsonParser  parser = new JsonParser();
String tags2=dbo.getString("Tags");
JsonElement elem   = parser.parse(tags2);
finalResult = elem.getAsJsonArray();
for(int i=o;i<finalResult .size();i++)
{
//Get individual array and get the fields as String and store it anywhere
}