JSONObject jsono = new JSONObject (myjsonstring);
JSONArray myListsAll= new JSONArray(jsono.getString("results"));
for(int i=0;i<myListsAll.length();i++){
JSONObject jsonObject1 = (JSONObject) myListsAll.get(i);
JSONArray myarray= new JSONArray(jsonObject1.getString("address_components"));
for(int i1=0;i1<myarray.length();i1++)
{
JSONObject jsonobject2 =  myarray.getJSONObject(i1);                     
System.out.println(""+jsonobject2.getString("long_name"));                  
System.out.println(""+jsonobject2.getString("short_name"));
System.out.println(""+jsonobject2.getString("types"));
}
}