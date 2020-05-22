docs = output.getJSONArray("testPoints");
JSONArray  properties= new JSONArray();
for(int i = 0; i < docs.size(); i++)
{
      JSONObject object = docs.getJSONObject(i);
      JSONArray  workItemProperties=object.getJSONArray("workItemProperties");
      JSONObject property=new JSONObject();
      for(int j = 0; j < workItemProperties.size(); j++)
         {
      JSONObject temp=workItemProperties.getJSONObject(j);
      property.put(temp.getString("Key"),temp.getString("Value"));
         }
      properties.put(property);
}

File file=new File("JSONextract.csv");
String csv = CDL.toString(properties);
FileUtils.writeStringToFile(file, csv)
System.out.println(csv);