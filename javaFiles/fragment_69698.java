JSONArray jsonArray = new JSONArray(response);       

  for(int i=0;i < jsonArray.length(); i++) 
  {
    JSONObject jsonObject= jsonArray.getJSONObject(i);

     //JSONObject jsonObject1=jsonArray.getJSONObject(i);
     String rtrname=jsonObject.getString("rtrname").toString();
     String ctgname=jsonObject.getString("ctgname").toString();
     String rtrphoneno=jsonObject.getString("rtrphoneno").toString();

     str+= "\n rtrname:"+rtrname+"\n ctgname:"+ctgname+"\n rtrphoneno:" +rtrphoneno+"\n";
     boolean isInserted = database.insertData(rtrname,ctgname,rtrphoneno);
  }