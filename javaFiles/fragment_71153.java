String[] classes=new String[len];
for(nt i=0;i<len;i++)
{
 Map map=new Hashmap();
 classes[i]=json.JSONObject(i).get("Cls").toString();
 map.put("cls",Cls[i]);