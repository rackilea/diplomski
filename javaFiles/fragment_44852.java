JSONObject obj = new JSONObject();
List<SomeClass> sList = new ArrayList<SomeClass>();

SomeClass obj1 = new SomeClass();
obj1.setValue("val1");
sList.add(obj1);

SomeClass obj2 = new SomeClass();
obj2.setValue("val2");
sList.add(obj2);

obj.put("list", sList);

JSONArray jArray = obj.getJSONArray("list");
for(int ii=0; ii < jArray.length(); ii++)
  System.out.println(jArray.getJSONObject(ii).getString("value"));