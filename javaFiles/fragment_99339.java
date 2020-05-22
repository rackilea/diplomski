List mybeanList = new ArrayList();
mybeanList.add(myBean1);
mybeanList.add(myBean2);

JSONArray jsonArray = JSONArray.fromObject(mybeanList);
System.out.println("==== : "+jsonArray);

Map map = new HashMap();
map.put("beanlist", jsonArray);

JSONObject jsonObject = JSONObject.fromObject(map);
return jsonObject;