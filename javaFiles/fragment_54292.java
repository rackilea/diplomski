docs = output.getJSONArray("testPoints");
for(int i = 0; i < docs.size(); i++)
{
      JSONObject object = (JSONObject) docs.get(i);
      JSONArray  workItemProperties=object.getJSONArray("workItemProperties");
      for(int j = 0; j < workItemProperties.size(); j++)
         {
      JSONObject property=workItemProperties.getJSONObject(j);
      object.put(property.getString("Key"),property.getString("Value"));
         }
      object.remove("workItemProperties");
}

File file=new File("JSONextract.csv");
String csv = CDL.toString(docs);
FileUtils.writeStringToFile(file, csv)
System.out.println(csv);