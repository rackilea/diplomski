String str = "name=lokesh,age=25";
Map<String,String> map = new HashMap<String,String>();
for(String keyValueStr: str.split(",")){
     String[] keyValue = keyValueStr.split("=");
     map.put(keyValue[0],keyValue[1]);
 }