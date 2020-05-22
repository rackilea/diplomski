List<String> listdata = new ArrayList<>();
JSONArray jArray = jsonObject.getJSONArray(fldName);
if (jArray != null) { 
   for (int i=0;i<jArray.length();i++){ 
    listdata.add(jArray.getString(i));
   } 
} 

methList[i].invoke(mvo, listdata);