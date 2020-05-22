ArrayList<String> stringArray = new ArrayList<String>();
for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
    JSONObject map = (JSONObject)iterator.next();
    stringArray.add(map.get("Symbol")+" "+map.get("Name")+" "+map.get("Exchange"));
}
//stringArray is want you want