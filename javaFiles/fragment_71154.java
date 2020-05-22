int innerlen=json.getJSONArray("Classes").getJSONObject(i).getJSONArray("Section").length();
    String[] section=new String[innerlen];
    String secti=null;
for(int j=0;j<innerlen;j++)
    {
 section[j]=json.getJSONArray("Classes").getJSONObject(i).getJSONArray("Section").get(j).length();
    if(secti==null)
    {
      secti=section[j];
    }
     else
    {
     secti=secti+","+section[j];
    map.put("sections",secti);
}
   }
 list.add(map);